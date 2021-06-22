package com.example.drinkinggame.models;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Players {
    static Random random = new Random();
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

    public static Player getRandomPlayer() {
        int randNum = random.nextInt(players.size());
        return players.get(randNum);
    }

    public static ArrayList<Player> getRandomPlayers(int n) {

        ArrayList<Player> randomPlayers = new ArrayList<Player>();
        Collections.shuffle(players);

        for (int i=0; i<n; i++) {
            randomPlayers.add(players.get(i));
        }

        return randomPlayers;
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
