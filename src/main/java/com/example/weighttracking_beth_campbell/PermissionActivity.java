package com.example.weighttracking_beth_campbell;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.Toast;

public class PermissionActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_REQUEST_CODE = 123;
    private EditText editTextPhoneNumber;
    private Button btnRequestPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        btnRequestPermission = findViewById(R.id.btnRequestPermission);

        btnRequestPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the SMS permission is granted
                if (checkSmsPermission()) {
                    // send SMS messages
                    sendSms();
                } else {
                    // Permission not granted, request it from the user
                    requestSmsPermission();
                }
            }
        });
    }

    private boolean checkSmsPermission() {
        // Check if the SMS permission is granted
        return ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestSmsPermission() {
        // Request the SMS permission from the user
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.SEND_SMS},
                SMS_PERMISSION_REQUEST_CODE
        );
    }

    private void sendSms() {

        String phoneNumber = editTextPhoneNumber.getText().toString();
        String message = "Hello, this is your SMS message.";

        try {
            // Use SmsManager to send the SMS
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);

            // SMS sent successfully
            showToast("SMS sent successfully!");
        } catch (Exception e) {
            // Handle exceptions, e.g., if SMS sending fails
            showToast("Failed to send SMS. Please try again.");
            e.printStackTrace();
        }
    }

    // Helper method to show a toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Handle the result of the permission request
    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == SMS_PERMISSION_REQUEST_CODE) {
            // Check if the permission was granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, implement your logic here
                sendSms();
            } else {
                // Permission denied, handle it (e.g., show a message or disable the feature)
            }
        }
    }
}
