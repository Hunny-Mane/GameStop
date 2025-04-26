package com.example.gamestop;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    RecyclerView libraryRecycler;
    List<LibraryItem> libraryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ImageView back = findViewById(R.id.back6);
        back.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        libraryRecycler = findViewById(R.id.library_recycler);
        libraryRecycler.setLayoutManager(new LinearLayoutManager(this));

        libraryList.add(new LibraryItem("God of War", true, R.drawable.game1));
        libraryList.add(new LibraryItem("Cyberpunk 2077", false, R.drawable.game2));
        libraryList.add(new LibraryItem("Elden Ring", false, R.drawable.game3));

        libraryRecycler.setAdapter(new LibraryAdapter(libraryList));

        findViewById(R.id.back6).setOnClickListener(v -> {
            home_page.openDrawerOnResume6 = true;
            new Handler().postDelayed(() -> {
                getOnBackPressedDispatcher().onBackPressed();
            }, 100);
        });
    }
}
