package com.pasindu.plantit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final TextInputLayout tilEmail = findViewById(R.id.tilEmail);
        final TextInputLayout tilPassword = findViewById(R.id.tilPassword);
        final TextInputEditText etLoginEmail = findViewById(R.id.etLoginEmail);
        final TextInputEditText etLoginPassword = findViewById(R.id.etLoginPassword);
        MaterialButton btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;
                String email = etLoginEmail.getText() != null ? etLoginEmail.getText().toString().trim() : "";
                String password = etLoginPassword.getText() != null ? etLoginPassword.getText().toString() : "";

                // Email validation
                if (email.isEmpty()) {
                    tilEmail.setError("Email is required");
                    valid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    tilEmail.setError("Enter a valid email");
                    valid = false;
                } else {
                    tilEmail.setError(null);
                }

                // Password validation
                if (password.isEmpty()) {
                    tilPassword.setError("Password is required");
                    valid = false;
                } else if (password.length() < 6) {
                    tilPassword.setError("Password must be at least 6 characters");
                    valid = false;
                } else {
                    tilPassword.setError(null);
                }

                if (!valid) return;

                Login loginHelper = new Login(LoginActivity.this);
                boolean isValid = loginHelper.login(email, password);

                if (isValid) {
                    Intent intent = new Intent(LoginActivity.this, HomeInterface.class);
                    startActivity(intent);
                    finish();
                } else {
                    tilPassword.setError("Invalid email or password");
                }
            }
        });
    }
}

// Helper class for login logic
class Login {
    private final android.content.Context context;

    public Login(android.content.Context context) {
        this.context = context;
    }

    public boolean login(String email, String password) {
        DataBase db = new DataBase(context);
        return db.validateUser(email, password);
    }

    public void logout() {
        // Implement logout logic if needed (e.g., clear shared preferences)
    }
}
