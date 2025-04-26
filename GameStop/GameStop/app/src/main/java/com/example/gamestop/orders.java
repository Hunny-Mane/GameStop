package com.example.gamestop;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class orders extends AppCompatActivity {

    RecyclerView ordersRecycler;
    List<OrderItem> orderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        ordersRecycler = findViewById(R.id.orders_recycler);
        ordersRecycler.setLayoutManager(new LinearLayoutManager(this));

        ImageView back = findViewById(R.id.back4);
        back.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        orderList.add(new OrderItem("Elden Ring", "#ORD28903", "$59.99", "Delivered", R.drawable.game1));
        orderList.add(new OrderItem("Cyberpunk 2077", "#ORD28904", "$39.99", "Processing", R.drawable.game2));
        orderList.add(new OrderItem("Red Dead Redemption 2", "#ORD28905", "$49.99", "Cancelled", R.drawable.game3));

        ordersRecycler.setAdapter(new OrdersAdapter(orderList));

        findViewById(R.id.back4).setOnClickListener(v -> {
            home_page.openDrawerOnResume4 = true;
            new Handler().postDelayed(() -> {
                getOnBackPressedDispatcher().onBackPressed();
            }, 100);
        });
    }
}
