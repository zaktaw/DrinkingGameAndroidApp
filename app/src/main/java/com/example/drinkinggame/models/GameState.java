package com.example.drinkinggame.models;

public class GameState {
    static int maximumRounds;
    static int roundsElapsed;

    public GameState(int maximumRounds) {
        this.maximumRounds = maximumRounds;
        this.roundsElapsed = 0;
    }

    public static int getMaximumRounds() {
        return maximumRounds;
    }

    public void setMaximumRounds(int maximumRounds) {
        this.maximumRounds = maximumRounds;
    }

    public static int getRoundsElapsed() {
        return roundsElapsed;
    }

    public static void increaseRoundsElapsed() {
        roundsElapsed++;
    }

    public void setRoundsElapsed(int roundsElapsed) {
        this.roundsElapsed = roundsElapsed;
    }
}
