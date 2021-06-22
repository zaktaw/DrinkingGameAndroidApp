package com.example.drinkinggame.models.gameCards;

import android.util.Log;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

import java.util.ArrayList;

public class CategoryGame extends GameCard {
    public CategoryGame(String title, ArrayList<String> pages, int playersInvolved) {
        super(title, pages, playersInvolved);
    }

    public void action(String name) {
        Log.d("GameCard", "Hello from " + name);
    }

    public void endGame(Player loosingPlayer) {
        for (Player player : Players.getPlayers()) {
            if (player.getName().equals(loosingPlayer.getName())) {
                player.setCoins(player.getCoins() - 100);
            }
            else {
                player.setCoins(player.getCoins() + 100);
            }
        }
    }
}
