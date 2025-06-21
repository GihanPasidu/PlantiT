package com.pasindu.plantit;

import android.database.Cursor;
import android.content.Context;

public class UserProfile {
    private Context context;

    public UserProfile(Context context) {
        this.context = context;
    }

    public void showAllPlants() {
        DataBase db = new DataBase(context);
        Cursor cursor = db.getAllPlants();
        if (cursor != null) {
            int nameIdx = cursor.getColumnIndexOrThrow("name");
            int ageIdx = cursor.getColumnIndexOrThrow("age");
            while (cursor.moveToNext()) {
                String name = cursor.getString(nameIdx);
                int age = cursor.getInt(ageIdx);
                // Use 'name' and 'age' as needed
            }
            cursor.close();
        }
        // If your DataBase class has a close() method, call db.close() here.
    }
}
