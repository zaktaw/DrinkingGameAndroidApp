package com.example.drinkinggame.gameActivities.staticGameActivity;

public class StaticGame {
    String title;
    String description;
    boolean giveCoins;
    int amount;
    boolean targetPlayer; // if true give coins to a specific player, if false give coins to every player

    public StaticGame(String title, String description, boolean giveCoins, int amount, boolean targetPlayer) {
        this.title = title;
        this.description = description;
        this.giveCoins = giveCoins;
        this.amount = amount;
        this.targetPlayer = targetPlayer;
    }
}
