package com.pasindu.plantit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.google.android.material.button.MaterialButton;

public class HomeInterface extends Activity {
    private static final String TAG = "HomeInterface";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.homeinterface);
            initializeUI();
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
            Toast.makeText(this, "Error initializing app", Toast.LENGTH_LONG).show();
            // Fallback to main activity if there's a critical error
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    private void initializeUI() {
        try {
            // CardView: My Plants -> User Profile
            CardView cardViewPlants = findViewById(R.id.cardViewPlants);
            if (cardViewPlants != null) {
                cardViewPlants.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(HomeInterface.this, UserProfile.class);
                            startActivity(intent);
                        } catch (Exception e) {
                            Log.e(TAG, "Error navigating to User Profile", e);
                            Toast.makeText(HomeInterface.this, "Unable to open User Profile", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            // CardView: Add Plant -> Plant Profile
            CardView cardAddPlant = findViewById(R.id.cardAddPlant);
            if (cardAddPlant != null) {
                cardAddPlant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Prevent crash: No Activity to start here yet
                        Toast.makeText(HomeInterface.this, "Add Plant feature coming soon", Toast.LENGTH_SHORT).show();
                        // TODO: Implement Add Plant Activity and start it here
                    }
                });
            }

            // CardView: Disease Diagnosis -> Disease Detection
            CardView cardDiseaseDiagnosis = findViewById(R.id.cardDiseaseDiagnosis);
            if (cardDiseaseDiagnosis != null) {
                cardDiseaseDiagnosis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Prevent crash: No Activity to start here yet
                        Toast.makeText(HomeInterface.this, "Disease Diagnosis feature coming soon", Toast.LENGTH_SHORT).show();
                        // TODO: Implement Disease Detection Activity and start it here
                    }
                });
            }

            // CardView: Care Schedule -> Care Scheduler
            CardView cardCareSchedule = findViewById(R.id.cardCareSchedule);
            if (cardCareSchedule != null) {
                cardCareSchedule.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Prevent crash: No Activity to start here yet
                        Toast.makeText(HomeInterface.this, "Care Schedule feature coming soon", Toast.LENGTH_SHORT).show();
                        // TODO: Implement Care Scheduler Activity and start it here
                    }
                });
            }

            // CardView: Environmental Monitoring
            CardView cardEnvironmental = findViewById(R.id.cardEnvironmental);
            if (cardEnvironmental != null) {
                cardEnvironmental.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Prevent crash: No Activity to start here yet
                        Toast.makeText(HomeInterface.this, "Environmental Monitoring feature coming soon", Toast.LENGTH_SHORT).show();
                        // TODO: Implement Environmental Monitoring Activity and start it here
                    }
                });
            }

            // CardView: Nearby Services -> Navigation
            CardView cardNearbyServices = findViewById(R.id.cardNearbyServices);
            if (cardNearbyServices != null) {
                cardNearbyServices.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(HomeInterface.this, Navigation.class);
                            startActivity(intent);
                        } catch (Exception e) {
                            Log.e(TAG, "Error navigating to Nearby Services", e);
                            Toast.makeText(HomeInterface.this, "Unable to open Nearby Services", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            // Settings -> Settings Activity
            MaterialButton btnSettings = findViewById(R.id.btnSettings);
            if (btnSettings != null) {
                btnSettings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(HomeInterface.this, MainActivity.class);
                            startActivity(intent);
                        } catch (Exception e) {
                            Log.e(TAG, "Error navigating to Settings", e);
                            Toast.makeText(HomeInterface.this, "Unable to open Settings", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            // Logout
            MaterialButton btnLogout = findViewById(R.id.btnLogout);
            if (btnLogout != null) {
                btnLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Intent intent = new Intent(HomeInterface.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {
                            Log.e(TAG, "Error during logout", e);
                            Toast.makeText(HomeInterface.this, "Unable to logout", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "Error initializing UI components", e);
            Toast.makeText(this, "Error setting up the interface", Toast.LENGTH_SHORT).show();
        }
    }
}
