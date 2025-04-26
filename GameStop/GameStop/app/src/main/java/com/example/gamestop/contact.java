package com.example.gamestop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ImageView back = findViewById(R.id.back2);
        Button chatButton = findViewById(R.id.chat_button);
        Button sendMessageButton = findViewById(R.id.send_message_button);

        back.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        chatButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:support@gamestop.com"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Support Request");
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        });

        sendMessageButton.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:support@gamestop.com"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Support Request");
            startActivity(Intent.createChooser(emailIntent, "Send Email"));
        });

        findViewById(R.id.back2).setOnClickListener(v -> {
            home_page.openDrawerOnResume2 = true;
            new Handler().postDelayed(() -> {
                getOnBackPressedDispatcher().onBackPressed();
            }, 100);
        });
    }
}