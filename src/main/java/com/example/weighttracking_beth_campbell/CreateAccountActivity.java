package com.example.weighttracking_beth_campbell;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText editTextNewUsername, editTextNewPassword;
    private Button btnCreateAccount;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        editTextNewUsername = findViewById(R.id.editTextNewUsername);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        databaseHelper = new DatabaseHelper(this);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUsername = editTextNewUsername.getText().toString();
                String newPassword = editTextNewPassword.getText().toString();

                // Check if the username or password is empty
                if (newUsername.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Add the new user to the database
                    databaseHelper.addUser(newUsername, newPassword);
                    Toast.makeText(CreateAccountActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();

                    // Optionally, you can navigate to the login screen after account creation
                    finish();
                }
            }
        });
    }
}
