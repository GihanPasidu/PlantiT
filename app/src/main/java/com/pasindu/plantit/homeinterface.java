package com.pasindu.plantit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeinterface extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeinterface);

        // View My Plants -> Plant Profile Screen
        Button btnViewMyPlants = findViewById(R.id.btnViewMyPlants);
        btnViewMyPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement PlantListActivity
                startActivity(new Intent(homeinterface.this, PlantListActivity.class));
            }
        });

        // Add New Plant -> Plant Registration
        Button btnAddNewPlant = findViewById(R.id.btnAddNewPlant);
        btnAddNewPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement PlantRegistrationActivity
                startActivity(new Intent(homeinterface.this, PlantRegistrationActivity.class));
            }
        });

        // Disease Diagnosis -> Disease Diagnosis Screen
        Button btnDiseaseDiagnosis = findViewById(R.id.btnDiseaseDiagnosis);
        btnDiseaseDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement DiseaseDiagnosisActivity
                startActivity(new Intent(homeinterface.this, DiseaseDiagnosisActivity.class));
            }
        });

        // Care Schedule -> Care Schedule Screen
        Button btnCareSchedule = findViewById(R.id.btnCareSchedule);
        btnCareSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement CareScheduleActivity
                startActivity(new Intent(homeinterface.this, CareScheduleActivity.class));
            }
        });

        // Environmental Monitoring -> Environmental Monitoring Screen
        Button btnEnvironmentalMonitoring = findViewById(R.id.btnEnvironmentalMonitoring);
        btnEnvironmentalMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement EnvironmentalMonitoringActivity
                startActivity(new Intent(homeinterface.this, EnvironmentalMonitoringActivity.class));
            }
        });

        // Nearby Services -> Nearby Services (Google Map)
        Button btnNearbyServices = findViewById(R.id.btnNearbyServices);
        btnNearbyServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement NearbyServicesActivity
                startActivity(new Intent(homeinterface.this, NearbyServicesActivity.class));
            }
        });

        // Settings -> Settings Screen
        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement SettingsActivity
                startActivity(new Intent(homeinterface.this, SettingsActivity.class));
            }
        });

        // Logout
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeinterface.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
