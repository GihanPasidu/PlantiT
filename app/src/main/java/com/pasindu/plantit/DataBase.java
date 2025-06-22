package com.pasindu.plantit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PlantiT.db";
    private static final int DATABASE_VERSION = 1;

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLANTS_TABLE = "CREATE TABLE plants (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "type TEXT, " +
                "age INTEGER, " +
                "location TEXT, " +
                "notes TEXT, " +
                "image BLOB, " +
                "waterFrequency INTEGER, " +
                "fertilizeFrequency INTEGER, " +
                "sunlight TEXT" +
                ")";
        db.execSQL(CREATE_PLANTS_TABLE);

        String CREATE_USERS_TABLE = "CREATE TABLE users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "email TEXT UNIQUE, " +
                "password TEXT," +
                "name TEXT," +
                "memberSince TEXT," +
                "profilePicture BLOB" +
                ")";
        db.execSQL(CREATE_USERS_TABLE);

        String CREATE_CARE_SCHEDULES_TABLE = "CREATE TABLE care_schedules (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "plantId INTEGER, " +
                "task TEXT, " +
                "date TEXT, " +
                "time TEXT, " +
                "notes TEXT, " +
                "FOREIGN KEY(plantId) REFERENCES plants(id))";
        db.execSQL(CREATE_CARE_SCHEDULES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS plants");
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS care_schedules");
        onCreate(db);
    }

    // Updated insertPlant to include all plant profile fields
    public long insertPlant(String name, String type, int age, String location, String notes, byte[] imageData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("type", type);
        values.put("age", age);
        values.put("location", location);
        values.put("notes", notes);
        values.put("image", imageData);
        return db.insert("plants", null, values);
    }

    public Cursor getAllPlants() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM plants", null);
    }

    // Register a new user (email, password only)
    public boolean registerUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        long result = db.insert("users", null, values);
        return result != -1;
    }

    // Register a new user with name
    public boolean registerUserWithName(String email, String password, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        values.put("name", name);
        long result = db.insert("users", null, values);
        return result != -1;
    }

    // Validate user login
    public boolean validateUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(
            "SELECT id FROM users WHERE email=? AND password=?",
            new String[]{email, password}
        );
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

    // Update user profile data
    public boolean updateUserProfile(String email, String name, String memberSince, byte[] profilePicture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("memberSince", memberSince);
        values.put("profilePicture", profilePicture);
        int rows = db.update("users", values, "email=?", new String[]{email});
        return rows > 0;
    }

    // Get user profile data by email
    public Cursor getUserProfile(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
            "SELECT name, email, memberSince, profilePicture FROM users WHERE email=?",
            new String[]{email}
        );
    }

    // Insert a care schedule entry
    public long insertCareSchedule(int plantId, String task, String date, String time, String notes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("plantId", plantId);
        values.put("task", task);
        values.put("date", date);
        values.put("time", time);
        values.put("notes", notes);
        return db.insert("care_schedules", null, values);
    }

    // Get all care schedules for a plant
    public Cursor getCareSchedulesForPlant(int plantId) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
            "SELECT * FROM care_schedules WHERE plantId=? ORDER BY date, time",
            new String[]{String.valueOf(plantId)}
        );
    }

    // Get care plan details for a plant
    public Cursor getCarePlanForPlant(int plantId) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
            "SELECT waterFrequency, fertilizeFrequency, sunlight FROM plants WHERE id=?",
            new String[]{String.valueOf(plantId)}
        );
    }

    // Update care plan details for a plant
    public boolean updateCarePlanForPlant(int plantId, int waterFrequency, int fertilizeFrequency, String sunlight) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("waterFrequency", waterFrequency);
        values.put("fertilizeFrequency", fertilizeFrequency);
        values.put("sunlight", sunlight);
        int rows = db.update("plants", values, "id=?", new String[]{String.valueOf(plantId)});
        return rows > 0;
    }
}
