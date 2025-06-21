package com.pasindu.plantit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.google.android.material.button.MaterialButton;

public class HomeInterface extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeinterface);

        // CardView: My Plants -> User Profile
        CardView cardViewPlants = findViewById(R.id.cardViewPlants);
        cardViewPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomeInterface.this, UserProfile.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // CardView: Add Plant -> Plant Profile
        CardView cardAddPlant = findViewById(R.id.cardAddPlant);
        cardAddPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomeInterface.this, PlantProfile.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // CardView: Disease Diagnosis -> Disease Detection
        CardView cardDiseaseDiagnosis = findViewById(R.id.cardDiseaseDiagnosis);
        cardDiseaseDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomeInterface.this, DiseaseDetection.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // CardView: Care Schedule -> Care Scheduler
        CardView cardCareSchedule = findViewById(R.id.cardCareSchedule);
        cardCareSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomeInterface.this, CareScheduler.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // CardView: Nearby Services -> Navigation
        CardView cardNearbyServices = findViewById(R.id.cardNearbyServices);
        cardNearbyServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(HomeInterface.this, Navigation.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Settings -> Settings Activity (unchanged)
        MaterialButton btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeInterface.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Logout (unchanged)
        MaterialButton btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeInterface.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
