package com.example.drinkinggame.models;

import java.util.ArrayList;

public class Players {
    static ArrayList<Player> players;

    public Players() {
        this.players = new ArrayList<Player>();
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static String playersToString() {

        String playersString = "";

        if (players.size() > 0) {playersString = players.get(0).getName();}
        else {return playersString;}

        for (int i=1; i<players.size(); i++) {
            playersString += "\n" + players.get(i).getName();
        }

        return playersString;
    }
}
