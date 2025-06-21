package com.pasindu.plantit;

import android.content.Context;
import android.util.Patterns;

public class SignUpActivity {
    private Context context;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean termsAccepted;

    public SignUpActivity(Context context, String fullName, String email, String password, String confirmPassword, boolean termsAccepted) {
        this.context = context;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.termsAccepted = termsAccepted;
    }

    public String validate() {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "Full name is required";
        }
        if (email == null || email.trim().isEmpty()) {
            return "Email is required";
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Enter a valid email";
        }
        if (password == null || password.isEmpty()) {
            return "Password is required";
        }
        if (password.length() < 8) {
            return "Password must be at least 8 characters";
        }
        if (confirmPassword == null || !password.equals(confirmPassword)) {
            return "Passwords do not match";
        }
        if (!termsAccepted) {
            return "You must accept the Terms & Conditions";
        }
        return null; // All validations passed
    }

    public boolean register() {
        String validationError = validate();
        if (validationError != null) {
            // You can show this error in UI
            return false;
        }
        DataBase db = new DataBase(context);
        // Store full name as well
        boolean result = db.registerUserWithName(email, password, fullName);
        return result;
    }

    public Context getContext() {
        return context;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }
}
