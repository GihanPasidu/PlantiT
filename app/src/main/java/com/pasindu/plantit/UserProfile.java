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

    // Save user profile data to database
    public boolean saveProfile(String email, String name, String memberSince, byte[] profilePicture) {
        DataBase db = new DataBase(context);
        return db.updateUserProfile(email, name, memberSince, profilePicture);
    }

    // Load user profile data from database
    public UserData loadProfile(String email) {
        DataBase db = new DataBase(context);
        Cursor cursor = db.getUserProfile(email);
        UserData userData = null;
        if (cursor != null && cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String memberSince = cursor.getString(cursor.getColumnIndexOrThrow("memberSince"));
            byte[] profilePicture = cursor.getBlob(cursor.getColumnIndexOrThrow("profilePicture"));
            userData = new UserData(name, userEmail, memberSince, profilePicture);
            cursor.close();
        }
        return userData;
    }

    // Helper class to hold user data
    public static class UserData {
        public String name;
        public String email;
        public String memberSince;
        public byte[] profilePicture;

        public UserData(String name, String email, String memberSince, byte[] profilePicture) {
            this.name = name;
            this.email = email;
            this.memberSince = memberSince;
            this.profilePicture = profilePicture;
        }
    }
}
