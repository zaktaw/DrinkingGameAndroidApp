package com.example.drinkinggame.models;

public class Player {
    String name;
    int coins;

    public Player(String name) {
        this.name = name;
        this.coins = 1000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void giveCoins(int coins) {
        this.coins += coins;
        if (this.coins < 0) this.coins = 0; // a player's coins can't go below 0
    }
}
