package com.pasindu.plantit;

import android.content.Context;

public class plantprofile {
    private Context context;

    public plantprofile(Context context) {
        this.context = context;
    }

    public void registerPlant(String name, int age, byte[] imageData) {
        database db = new database(context);
        db.insertPlant(name, age, imageData);
    }
}
