package com.pasindu.plantit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton btnGetStarted = findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton btnOpenFeatures = findViewById(R.id.btnOpenFeatures);
        btnOpenFeatures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Navigation activity
                Intent intent = new Intent(MainActivity.this, Navigation.class);
                startActivity(intent);
            }
        });
    }
}