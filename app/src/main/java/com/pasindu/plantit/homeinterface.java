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

        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnPlantRegistration = findViewById(R.id.btnPlantRegistration);
        Button btnDiseaseDetection = findViewById(R.id.btnDiseaseDetection);
        Button btnSensorMonitoring = findViewById(R.id.btnSensorMonitoring);
        Button btnNavigation = findViewById(R.id.btnNavigation);
        Button btnLogout = findViewById(R.id.btnLogout);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeinterface.this, userprofile.class));
            }
        });

        btnPlantRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeinterface.this, plantprofile.class));
            }
        });

        btnDiseaseDetection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeinterface.this, diseasedetection.class));
            }
        });

        btnSensorMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeinterface.this, sensormonitoring.class));
            }
        });

        btnNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeinterface.this, navigation.class));
            }
        });

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
