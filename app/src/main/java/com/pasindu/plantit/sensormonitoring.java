package com.pasindu.plantit;

public class sensormonitoring {
    public boolean isEnvironmentSuitable(float temperature, float humidity) {
        boolean suitable = (temperature >= 15 && temperature <= 30) && (humidity >= 40 && humidity <= 70);
        if (!suitable) {
            new notification().sendPlantCareAlert("Environment is not suitable!");
        }
        return suitable;
    }
}
