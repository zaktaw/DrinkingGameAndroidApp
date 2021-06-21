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
}
