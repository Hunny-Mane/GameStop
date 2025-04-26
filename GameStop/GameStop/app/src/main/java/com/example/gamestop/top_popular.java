package com.example.gamestop;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class top_popular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_popular);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewGames2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        List<Game> games = new ArrayList<>();
        games.add(new Game(getString(R.string.valorant), R.drawable.game1, "$0", "Valorant is a 2020 first-person tactical hero shooter video game developed and published by Riot Games.[3] A free-to-play game, Valorant takes inspiration from the Counter-Strike series, borrowing several mechanics such as the buy menu, spray patterns, and inaccuracy while moving."));
        games.add(new Game(getString(R.string.elden_ring), R.drawable.game3, "$59.99", "Elden Ring[b] is a 2022 action role-playing game developed by FromSoftware. It was directed by Hidetaka Miyazaki "));
        games.add(new Game(getString(R.string.witcher), R.drawable.game4, "$39.99", "The Witcher 3: Wild Hunt[c] is a 2015 action role-playing game developed and published by the Polish studio CD Projekt."));
        games.add(new Game(getString(R.string.legend), R.drawable.game5, "$0", "A competitive MOBA game by Riot Games."));
        games.add(new Game(getString(R.string.valorant), R.drawable.game6, "$0", "Valorant is a 2020 first-person tactical hero shooter video game developed and published by Riot Games.[3] A free-to-play game, Valorant takes inspiration from the Counter-Strike series, borrowing several mechanics such as the buy menu, spray patterns, and inaccuracy while moving."));
        games.add(new Game(getString(R.string.elden_ring), R.drawable.game7, "$59.99", "Elden Ring[b] is a 2022 action role-playing game developed by FromSoftware. It was directed by Hidetaka Miyazaki "));
        games.add(new Game(getString(R.string.witcher), R.drawable.game8, "$39.99", "The Witcher 3: Wild Hunt[c] is a 2015 action role-playing game developed and published by the Polish studio CD Projekt."));
        games.add(new Game(getString(R.string.valorant), R.drawable.game2, "$0", "Valorant is a 2020 first-person tactical hero shooter video game developed and published by Riot Games.[3] A free-to-play game, Valorant takes inspiration from the Counter-Strike series, borrowing several mechanics such as the buy menu, spray patterns, and inaccuracy while moving."));
        games.add(new Game(getString(R.string.elden_ring), R.drawable.game3, "$59.99", "Elden Ring[b] is a 2022 action role-playing game developed by FromSoftware. It was directed by Hidetaka Miyazaki "));
        games.add(new Game(getString(R.string.witcher), R.drawable.game4, "$39.99", "The Witcher 3: Wild Hunt[c] is a 2015 action role-playing game developed and published by the Polish studio CD Projekt."));
        games.add(new Game(getString(R.string.valorant), R.drawable.game2, "$0", "Valorant is a 2020 first-person tactical hero shooter video game developed and published by Riot Games.[3] A free-to-play game, Valorant takes inspiration from the Counter-Strike series, borrowing several mechanics such as the buy menu, spray patterns, and inaccuracy while moving."));
        games.add(new Game(getString(R.string.elden_ring), R.drawable.game3, "$59.99", "Elden Ring[b] is a 2022 action role-playing game developed by FromSoftware. It was directed by Hidetaka Miyazaki "));
        games.add(new Game(getString(R.string.witcher), R.drawable.game4, "$39.99", "The Witcher 3: Wild Hunt[c] is a 2015 action role-playing game developed and published by the Polish studio CD Projekt."));


        GameAdapter adapter = new GameAdapter(this,games);
        recyclerView.setAdapter(adapter);
    }
}
