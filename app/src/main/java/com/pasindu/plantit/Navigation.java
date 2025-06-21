package com.pasindu.plantit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.google.android.material.button.MaterialButton;
import android.content.Intent;

public class Navigation extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

        // Card: Plant Clinics
        CardView cardClinics = findViewById(R.id.cardClinics);
        cardClinics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder: Navigate to MainActivity
                Intent intent = new Intent(Navigation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Card: Garden Shops
        CardView cardShops = findViewById(R.id.cardShops);
        cardShops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder: Navigate to MainActivity
                Intent intent = new Intent(Navigation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Button: Mark Location
        MaterialButton btnMarkLocation = findViewById(R.id.btnMarkLocation);
        btnMarkLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder: Navigate to MainActivity
                Intent intent = new Intent(Navigation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Button: Refresh Weather
        MaterialButton btnRefreshWeather = findViewById(R.id.btnRefreshWeather);
        btnRefreshWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder: Navigate to MainActivity
                Intent intent = new Intent(Navigation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Button: Show Clinics (Quick Action)
        MaterialButton btnShowClinics = findViewById(R.id.btnShowClinics);
        btnShowClinics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder: Navigate to MainActivity
                Intent intent = new Intent(Navigation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Button: Buy Tools (Quick Action)
        MaterialButton btnBuyTools = findViewById(R.id.btnBuyTools);
        btnBuyTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder: Navigate to MainActivity
                Intent intent = new Intent(Navigation.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void showNearbyClinics() {
        Toast.makeText(this, "Showing nearby clinics...", Toast.LENGTH_SHORT).show();
    }

    public void markPlantingLocation() {
        Toast.makeText(this, "Marking planting location...", Toast.LENGTH_SHORT).show();
    }

    public void showWeather() {
        Toast.makeText(this, "Showing weather...", Toast.LENGTH_SHORT).show();
    }

    public void navigateToBuyTools() {
        Toast.makeText(this, "Navigating to buy tools...", Toast.LENGTH_SHORT).show();
    }
}
