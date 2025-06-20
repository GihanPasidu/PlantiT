package com.pasindu.plantit;

import android.database.Cursor;
import android.content.Context;

public class userprofile {
    private Context context;

    public userprofile(Context context) {
        this.context = context;
    }

    public void showAllPlants() {
        database db = new database(context);
        Cursor cursor = db.getAllPlants();
        while (cursor.moveToNext()) {
            // Use cursor.getString(...) etc. to retrieve plant data
        }
        cursor.close();
    }
}
