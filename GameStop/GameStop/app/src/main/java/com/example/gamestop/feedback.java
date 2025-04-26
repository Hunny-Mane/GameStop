package com.example.gamestop;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class feedback extends AppCompatActivity {

    EditText nameField, emailField, messageField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ImageView back = findViewById(R.id.back3);
        nameField = findViewById(R.id.feedback_name);
        emailField = findViewById(R.id.feedback_email);
        messageField = findViewById(R.id.feedback_message);
        Button submitButton = findViewById(R.id.submit_feedback_button);

        back.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        submitButton.setOnClickListener(v -> {
            String name = nameField.getText().toString().trim();
            String email = emailField.getText().toString().trim();
            String message = messageField.getText().toString().trim();

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(message)) {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Feedback submitted. Thank you!", Toast.LENGTH_LONG).show();

            nameField.setText("");
            emailField.setText("");
            messageField.setText("");
        });
        findViewById(R.id.back3).setOnClickListener(v -> {
            home_page.openDrawerOnResume3 = true;
            new Handler().postDelayed(() -> {
                getOnBackPressedDispatcher().onBackPressed();
            }, 100);
        });
    }


}