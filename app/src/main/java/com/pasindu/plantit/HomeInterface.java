package com.pasindu.plantit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeInterface extends Activity {
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
                // Uncomment the next line if PlantListActivity exists
                // startActivity(new Intent(HomeInterface.this, PlantListActivity.class));
            }
        });

        // Add New Plant -> Plant Registration
        Button btnAddNewPlant = findViewById(R.id.btnAddNewPlant);
        btnAddNewPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement PlantRegistrationActivity
                // Uncomment the next line if PlantRegistrationActivity exists
                // startActivity(new Intent(HomeInterface.this, PlantRegistrationActivity.class));
            }
        });

        // Disease Diagnosis -> Disease Diagnosis Screen
        Button btnDiseaseDiagnosis = findViewById(R.id.btnDiseaseDiagnosis);
        btnDiseaseDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement DiseaseDiagnosisActivity
                // Uncomment the next line if DiseaseDiagnosisActivity exists
                // startActivity(new Intent(HomeInterface.this, DiseaseDiagnosisActivity.class));
            }
        });

        // Care Schedule -> Care Schedule Screen
        Button btnCareSchedule = findViewById(R.id.btnCareSchedule);
        btnCareSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement CareScheduleActivity
                // Uncomment the next line if CareScheduleActivity exists
                // startActivity(new Intent(HomeInterface.this, CareScheduleActivity.class));
            }
        });

        // Environmental Monitoring -> Environmental Monitoring Screen
        Button btnEnvironmentalMonitoring = findViewById(R.id.btnEnvironmentalMonitoring);
        btnEnvironmentalMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement EnvironmentalMonitoringActivity
                // Uncomment the next line if EnvironmentalMonitoringActivity exists
                // startActivity(new Intent(HomeInterface.this, EnvironmentalMonitoringActivity.class));
            }
        });

        // Nearby Services -> Nearby Services (Google Map)
        Button btnNearbyServices = findViewById(R.id.btnNearbyServices);
        btnNearbyServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement NearbyServicesActivity
                // Uncomment the next line if NearbyServicesActivity exists
                // startActivity(new Intent(HomeInterface.this, NearbyServicesActivity.class));
            }
        });

        // Settings -> Settings Screen
        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement SettingsActivity
                // Uncomment the next line if SettingsActivity exists
                // startActivity(new Intent(HomeInterface.this, SettingsActivity.class));
            }
        });

        // Logout
        Button btnLogout = findViewById(R.id.btnLogout);
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
