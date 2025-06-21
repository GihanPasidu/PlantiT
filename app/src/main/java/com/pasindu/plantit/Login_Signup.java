package com.pasindu.plantit;

import android.content.Context;

public class Login_Signup {
    private Context context;

    public Login_Signup(Context context) {
        this.context = context;
    }

    public boolean login(String email, String password) {
        DataBase db = new DataBase(context);
        return db.validateUser(email, password);
    }

    public boolean signup(String email, String password) {
        DataBase db = new DataBase(context);
        return db.registerUser(email, password);
    }
}
