package com.example.drinkinggame.models;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Players {
    static Random random = new Random();
    static ArrayList<Player> players;
    static int playerTurnCounter;

    public Players() {
        this.players = new ArrayList<Player>();
        this.playerTurnCounter = 0;
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static int getPlayersSize() {return players.size();}

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

    public static void shufflePlayers() {
        Collections.shuffle(players);
    }

    public static Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public static Player getNextPlayer() {
        Player player = players.get(playerTurnCounter);
        playerTurnCounter++;
        if (playerTurnCounter == players.size()) {
            Collections.shuffle(players);
            playerTurnCounter = 0;
        }
        return player;
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

    public static void increaseCoinsAllPlayers(int amount) {
        for (Player player : players) {
            player.giveCoins(amount);
        }
    }
}
