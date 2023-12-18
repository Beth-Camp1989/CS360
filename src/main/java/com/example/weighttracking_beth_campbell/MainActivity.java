package com.example.weighttracking_beth_campbell;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import static android.content.Context.MODE_PRIVATE;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the user is logged in
        boolean userLoggedIn = checkIfUserLoggedIn();

        // Decide which activity to launch based on the user's login status
        if (userLoggedIn) {
            // User is logged in, open the Data Display Activity
            startActivity(new Intent(MainActivity.this, DataDisplayActivity.class));
        } else {
            // User is not logged in, open the Login Activity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        // Finish the MainActivity so that it's removed from the back stack
        finish();
    }


    private boolean checkIfUserLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);

        // Return the login status
        return isLoggedIn;
    }
}
