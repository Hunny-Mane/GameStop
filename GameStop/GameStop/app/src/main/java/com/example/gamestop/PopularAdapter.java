package com.example.gamestop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.GameViewHolder> {
    private Context context;
    private List<Popular> popularList;

    public PopularAdapter(Context context, List<Popular> popularList) {
        this.context = context;
        this.popularList = popularList;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_game2, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Popular game = popularList.get(position);
        holder.nameTextView.setText(game.getName());
        holder.priceTextView.setText(game.getPrice());
        holder.imageView.setImageResource(game.getImageResId());
    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    static class GameViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, priceTextView;
        ImageView imageView;

        GameViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.gameName2);
            priceTextView = itemView.findViewById(R.id.gamePrice2);
            imageView = itemView.findViewById(R.id.gameImage2);
        }
    }
}
