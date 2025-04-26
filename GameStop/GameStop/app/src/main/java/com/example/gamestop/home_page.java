package com.example.gamestop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;

import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class home_page extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    public NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    public static boolean openDrawerOnResume = false;
    public static boolean openDrawerOnResume1 = false;
    public static boolean openDrawerOnResume2 = false;
    public static boolean openDrawerOnResume3 = false;
    public static boolean openDrawerOnResume4 = false;
    public static boolean openDrawerOnResume5 = false;
    public static boolean openDrawerOnResume6 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        ImageView ic1 = findViewById(R.id.ci1);
        ic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(home_page.this, cart.class);
                    startActivity(intent);
            }
        });

        TextView tv1 = findViewById(R.id.tv11);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, top_deals.class);
                startActivity(intent);
            }
        });
        TextView tv2 = findViewById(R.id.tv9);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, top_rated.class);
                startActivity(intent);
            }
        });
        TextView tv3 = findViewById(R.id.tv10);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this, top_popular.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(home_page.this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this, android.R.color.white));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_profile) {
                    Toast.makeText(home_page.this, "Profile", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_settings) {
                    Toast.makeText(home_page.this, "Settings", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_logout) {
                    Intent intent = new Intent(home_page.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else if (id == R.id.nav_top_deals) {
                    Intent intent = new Intent(home_page.this, top_deals.class);
                    startActivity(intent);
                } else if (id == R.id.nav_top_rated) {
                    Intent intent = new Intent(home_page.this, top_rated.class);
                    startActivity(intent);
                } else if (id == R.id.nav_help) {
                    Intent intent = new Intent(home_page.this, HelpActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_cart) {
                    openDrawerOnResume5 = true;
                    Intent intent = new Intent(home_page.this, cart.class);
                    startActivity(intent);
                } else if (id == R.id.nav_contactus) {
                    Intent intent = new Intent(home_page.this, contact.class);
                    startActivity(intent);
                } else if (id == R.id.nav_feedback) {
                    Intent intent = new Intent(home_page.this, feedback.class);
                    startActivity(intent);
                } else if (id == R.id.nav_faq) {
                    Intent intent = new Intent(home_page.this, FAQ.class);
                    startActivity(intent);
                } else if (id == R.id.nav_library) {
                    Intent intent = new Intent(home_page.this, LibraryActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_orders) {
                    Intent intent = new Intent(home_page.this, orders.class);
                    startActivity(intent);
                } else if (id == R.id.nav_top_popular) {
                    Intent intent = new Intent(home_page.this, top_popular.class);
                    startActivity(intent);
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });


        ImageSwitcher imageSwitcher = findViewById(R.id.imageView);
        imageSwitcher.setFactory(() -> {
            ImageView img = new ImageView(getApplicationContext());
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setLayoutParams(new ImageSwitcher.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return img;
        });

        int[] images = {
                R.drawable.genshin_landscape,
                R.drawable.fifa_landscape,
                R.drawable.genshin_landscape,
                R.drawable.pokemon_landscape,
                R.drawable.nfs_landsacpe

        };

        final int[] currentIndex = {0};

        Handler handler = new Handler();
        Runnable imageSlider = new Runnable() {
            @Override
            public void run() {
                currentIndex[0] = (currentIndex[0] + 1) % images.length;
                imageSwitcher.setImageResource(images[currentIndex[0]]);
                handler.postDelayed(this, 4000);
            }
        };

        imageSwitcher.setImageResource(images[currentIndex[0]]);
        handler.postDelayed(imageSlider, 4000);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (openDrawerOnResume) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            openDrawerOnResume = false;
        }
        if (openDrawerOnResume1) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            openDrawerOnResume1 = false;
        }
        if (openDrawerOnResume2) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            openDrawerOnResume2 = false;
        }
        if (openDrawerOnResume3) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            openDrawerOnResume3 = false;
        }
        if (openDrawerOnResume4) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            openDrawerOnResume4 = false;
        }
        if (openDrawerOnResume5) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            openDrawerOnResume5 = false;
        }
        if (openDrawerOnResume6) {
            DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
            drawerLayout.openDrawer(GravityCompat.START);
            openDrawerOnResume6 = false;
        }
    }




}
