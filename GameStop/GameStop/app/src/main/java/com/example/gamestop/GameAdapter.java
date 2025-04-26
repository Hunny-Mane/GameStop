package com.example.gamestop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
    private List<Game> gameList;
    private Context context;

    public GameAdapter(Context context, List<Game> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        holder.nameTextView.setText(game.getName());
        holder.priceTextView.setText(game.getPrice());
        holder.imageView.setImageResource(game.getImageResId());

        // Set click listener to open details activity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, GameDetailsActivity.class);
            intent.putExtra("name", game.getName());
            intent.putExtra("price", game.getPrice());
            intent.putExtra("imageResId", game.getImageResId());
            intent.putExtra("description", game.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    static class GameViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, priceTextView;
        ImageView imageView;

        GameViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.gameName);
            priceTextView = itemView.findViewById(R.id.gamePrice);
            imageView = itemView.findViewById(R.id.gameImage);
        }
    }
}
