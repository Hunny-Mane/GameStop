package com.example.gamestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {

    List<OrderItem> orders;

    public OrdersAdapter(List<OrderItem> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderItem item = orders.get(position);
        holder.gameTitle.setText(item.gameTitle);
        holder.orderId.setText("Order ID: " + item.orderId);
        holder.price.setText(item.price);
        holder.status.setText(item.status);

        switch (item.status.toLowerCase()) {
            case "cancelled":
                holder.status.setTextColor(0xFFFF5252);
                break;
            case "processing":
                holder.status.setTextColor(0xFFFFC107);
                break;
            case "delivered":
                holder.status.setTextColor(0xFF4CAF50);
                break;
            default:
                holder.status.setTextColor(0xFFFFFFFF);
                break;
        }

        holder.image.setImageResource(item.imageResId);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView gameTitle, orderId, price, status;
        ImageView image;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.order_game_image);
            gameTitle = itemView.findViewById(R.id.order_game_title);
            orderId = itemView.findViewById(R.id.order_id);
            price = itemView.findViewById(R.id.order_price);
            status = itemView.findViewById(R.id.order_status);
        }
    }
}
