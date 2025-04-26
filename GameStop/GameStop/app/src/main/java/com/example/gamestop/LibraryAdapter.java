package com.example.gamestop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    List<LibraryItem> games;

    public LibraryAdapter(List<LibraryItem> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_library, parent, false);
        return new LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
        LibraryItem item = games.get(position);
        holder.title.setText(item.title);
        holder.image.setImageResource(item.imageResId);

        if (item.isInstalled) {
            holder.actionButton.setText("Download");
            holder.actionButton.setBackgroundTintList(holder.itemView.getResources().getColorStateList(R.color.green, null));
        } else {
            holder.actionButton.setText("Buy");
            holder.actionButton.setBackgroundTintList(holder.itemView.getResources().getColorStateList(R.color.primary_blue, null));
        }
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    static class LibraryViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        Button actionButton;

        public LibraryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.library_game_title);
            image = itemView.findViewById(R.id.library_game_image);
            actionButton = itemView.findViewById(R.id.library_action_button);
        }
    }
}
