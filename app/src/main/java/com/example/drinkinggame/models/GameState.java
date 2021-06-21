package com.example.drinkinggame.models;

public class GameState {
    int maximumRounds;
    int roundsElapsed;

    public GameState(int maximumRounds) {
        this.maximumRounds = maximumRounds;
        this.roundsElapsed = 0;
    }

    public int getMaximumRounds() {
        return maximumRounds;
    }

    public void setMaximumRounds(int maximumRounds) {
        this.maximumRounds = maximumRounds;
    }

    public int getRoundsElapsed() {
        return roundsElapsed;
    }

    public void setRoundsElapsed(int roundsElapsed) {
        this.roundsElapsed = roundsElapsed;
    }
}
