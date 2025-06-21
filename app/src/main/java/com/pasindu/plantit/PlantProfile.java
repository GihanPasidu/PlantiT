package com.pasindu.plantit;

import android.content.Context;

public class PlantProfile {
    private Context context;

    public PlantProfile(Context context) {
        this.context = context;
    }

    public void registerPlant(String name, int age, byte[] imageData) {
        DataBase db = new DataBase(context);
        db.insertPlant(name, age, imageData);
    }
}
