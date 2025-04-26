package com.example.gamestop;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        ImageView gameImage = findViewById(R.id.gameDetailImage);
        TextView gameName = findViewById(R.id.gameDetailName);
        TextView gamePrice = findViewById(R.id.gameDetailPrice);
        TextView gameDescription = findViewById(R.id.gameDetailDescription);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            gameName.setText(extras.getString("name"));
            gamePrice.setText(extras.getString("price"));
            gameImage.setImageResource(extras.getInt("imageResId"));
            gameDescription.setText(extras.getString("description"));
        }
    }
}
