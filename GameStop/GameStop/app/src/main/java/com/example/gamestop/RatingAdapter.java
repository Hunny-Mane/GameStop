package com.example.gamestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.GameViewHolder> {
    private List<Game> gameList;

    public RatingAdapter(List<Game> gameList) {
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game1, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        holder.nameTextView.setText(game.getName());
        holder.priceTextView.setText(game.getPrice());
        holder.imageView.setImageResource(game.getImageResId());
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
            nameTextView = itemView.findViewById(R.id.gameName1);
            priceTextView = itemView.findViewById(R.id.gamePrice1);
            imageView = itemView.findViewById(R.id.gameImage1);
        }
    }
}
