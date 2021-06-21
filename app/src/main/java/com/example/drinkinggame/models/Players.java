package com.example.drinkinggame.models;

import java.util.ArrayList;

public class Players {
    ArrayList players;

    public Players() {
        this.players = new ArrayList();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public ArrayList getPlayers() {
        return players;
    }
}
