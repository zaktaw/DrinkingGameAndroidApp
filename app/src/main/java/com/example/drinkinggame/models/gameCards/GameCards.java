package com.example.drinkinggame.models.gameCards;

import com.example.drinkinggame.models.Player;

import java.util.ArrayList;
import java.util.Random;

public class GameCards {
    static Random random = new Random();
    static ArrayList<GameCard> gameCards;

    public GameCards() {
        this.gameCards = new ArrayList<GameCard>();
    }

    public static void addGameCard(GameCard gameCard) {
        gameCards.add(gameCard);
    }

    public static ArrayList<GameCard> getGameCards() {
        return gameCards;
    }

    public static GameCard getGameCard(int index) {
        return gameCards.get(index);
    }

    public static GameCard getRandomGameCard() {
        int randNum = random.nextInt(gameCards.size());
        return gameCards.get(randNum);
    }
}
