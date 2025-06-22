package com.pasindu.plantit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final TextInputLayout tilFullName = findViewById(R.id.tilFullName);
        final TextInputLayout tilEmail = findViewById(R.id.tilEmail);
        final TextInputLayout tilPassword = findViewById(R.id.tilPassword);
        final TextInputLayout tilConfirmPassword = findViewById(R.id.tilConfirmPassword);
        final TextInputEditText etFullName = findViewById(R.id.etSignupFullName);
        final TextInputEditText etEmail = findViewById(R.id.etSignupEmail);
        final TextInputEditText etPassword = findViewById(R.id.etSignupPassword);
        final TextInputEditText etConfirmPassword = findViewById(R.id.etSignupConfirm);
        final MaterialCheckBox cbTerms = findViewById(R.id.cbTerms);
        final MaterialButton btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
                String email = etEmail.getText() != null ? etEmail.getText().toString().trim() : "";
                String password = etPassword.getText() != null ? etPassword.getText().toString() : "";
                String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString() : "";
                boolean termsAccepted = cbTerms != null && cbTerms.isChecked();

                boolean valid = true;

                if (fullName.isEmpty()) {
                    tilFullName.setError("Full name is required");
                    valid = false;
                } else {
                    tilFullName.setError(null);
                }

                if (email.isEmpty()) {
                    tilEmail.setError("Email is required");
                    valid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    tilEmail.setError("Enter a valid email");
                    valid = false;
                } else {
                    tilEmail.setError(null);
                }

                if (password.isEmpty()) {
                    tilPassword.setError("Password is required");
                    valid = false;
                } else if (password.length() < 8) {
                    tilPassword.setError("Password must be at least 8 characters");
                    valid = false;
                } else {
                    tilPassword.setError(null);
                }

                if (!password.equals(confirmPassword)) {
                    tilConfirmPassword.setError("Passwords do not match");
                    valid = false;
                } else {
                    tilConfirmPassword.setError(null);
                }

                if (!termsAccepted) {
                    if (cbTerms != null) cbTerms.setError("You must accept the Terms & Conditions");
                    valid = false;
                } else {
                    if (cbTerms != null) cbTerms.setError(null);
                }

                if (!valid) return;

                // Register user in database before navigating to HomeInterface
                DataBase db = new DataBase(SignUpActivity.this);
                boolean registered = db.registerUserWithName(email, password, fullName);

                if (registered) {
                    Intent intent = new Intent(SignUpActivity.this, HomeInterface.class);
                    startActivity(intent);
                    finish();
                } else {
                    tilEmail.setError("Email already exists");
                }
            }
        });

        // Optional: Enable/disable button based on terms checkbox
        if (cbTerms != null && btnSignUp != null) {
            cbTerms.setOnCheckedChangeListener((buttonView, isChecked) -> btnSignUp.setEnabled(isChecked));
            btnSignUp.setEnabled(cbTerms.isChecked());
        }

        // Handle "Sign In" text click to go to Login screen
        View tvSignIn = findViewById(R.id.tvSignIn);
        if (tvSignIn != null) {
            tvSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

        MaterialButton btnGoogleSignup = findViewById(R.id.btnGoogleSignup);
        if (btnGoogleSignup != null) {
            btnGoogleSignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Always go to HomeInterface after clicking Google sign up
                    Intent intent = new Intent(SignUpActivity.this, HomeInterface.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}
