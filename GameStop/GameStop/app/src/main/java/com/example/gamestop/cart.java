package com.example.gamestop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {

    RecyclerView cartRecycler;
    List<CartItem> cartList = new ArrayList<>();
    TextView totalPriceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ImageView back = findViewById(R.id.back5);
        cartRecycler = findViewById(R.id.cart_recycler);
        totalPriceView = findViewById(R.id.cart_total_price);
        Button checkoutButton = findViewById(R.id.cart_checkout_button);

        cartRecycler.setLayoutManager(new LinearLayoutManager(this));

        cartList.add(new CartItem("Elden Ring", "$59.99", R.drawable.game1));
        cartList.add(new CartItem("God of War", "$49.99", R.drawable.game2));
        cartList.add(new CartItem("RDR2", "$39.99", R.drawable.game3));

        cartRecycler.setAdapter(new CartAdapter(cartList));
        updateTotalPrice();

        back.setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        checkoutButton.setOnClickListener(v -> {
            Toast.makeText(cart.this, "Payment Done", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.back5).setOnClickListener(v -> {
            if (!home_page.openDrawerOnResume5){
                Intent intent = new Intent(cart.this, home_page.class);
                startActivity(intent);
            }else{
                new Handler().postDelayed(() -> {
                    getOnBackPressedDispatcher().onBackPressed();
                }, 100);
            }
        });
    }

    private void updateTotalPrice() {
        double total = 0;
        for (CartItem item : cartList) {
            total += Double.parseDouble(item.price.replace("$", ""));
        }
        totalPriceView.setText("$" + String.format("%.2f", total));
    }
}
