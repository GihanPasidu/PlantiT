package com.pasindu.plantit;

import android.content.Context;
import android.database.Cursor;

public class CareScheduler {
    private Context context;

    public CareScheduler(Context context) {
        this.context = context;
    }

    public String generateCarePlan(String plantName, int plantAge) {
        // Return a plan for watering and fertilizing
        return "Water every 2 days, Fertilize weekly.";
    }

    // Save a care schedule entry to the database
    public long saveCareSchedule(int plantId, String task, String date, String time, String notes) {
        DataBase db = new DataBase(context);
        return db.insertCareSchedule(plantId, task, date, time, notes);
    }

    // Retrieve all care schedules for a plant
    public Cursor getCareSchedules(int plantId) {
        DataBase db = new DataBase(context);
        return db.getCareSchedulesForPlant(plantId);
    }

    // Get care plan details for a plant
    public Cursor getCarePlan(int plantId) {
        DataBase db = new DataBase(context);
        return db.getCarePlanForPlant(plantId);
    }

    // Update care plan details for a plant
    public boolean updateCarePlan(int plantId, int waterFrequency, int fertilizeFrequency, String sunlight) {
        DataBase db = new DataBase(context);
        return db.updateCarePlanForPlant(plantId, waterFrequency, fertilizeFrequency, sunlight);
    }
}
