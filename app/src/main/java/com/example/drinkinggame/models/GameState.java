package com.example.drinkinggame.models;

import java.util.ArrayList;
import java.util.Collections;

public class GameState {
    private static int gameCardCounter;
    static ArrayList<String> gameCards;

    public GameState() {
        this.gameCardCounter = 0;
        this.gameCards = new ArrayList<>();
    }

    public void addGameCard(String gameCard) {
        gameCards.add(gameCard);
    }

    public static void shuffleGameCards() {
        Collections.shuffle(gameCards);
    }

    public static String getNextGameCard() {
        String gameCard = gameCards.get(gameCardCounter);
        gameCardCounter++;
        return gameCard;
    }

    // game is over when there aren't more cards left. This is handled in each game activity.
    public static boolean isGameOver() {
        if (gameCardCounter == gameCards.size()) return true;
        else return false;
    }
}
