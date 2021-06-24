package com.example.drinkinggame.gameActivities.staticGameActivity;

import java.util.ArrayList;
import java.util.Collections;

public class StaticGames {
    static ArrayList<StaticGame> games;
    static int counter;

    public StaticGames() {
        games = new ArrayList<>();
        games.add(new StaticGame("Dyrelyder", "Hver spiller sier en dyrelyd og drikker en slurk. Man kan ikke si en lyd som allerede er sagt. [PLAYER] starter.", false, 0, false));
        games.add(new StaticGame("Dansebevegelse", "Hver spiller gjør en dansebevegelse og drikker en slurk. Man kan ikke gjøre en dansebevegelse som allerede er gjort. [PLAYER] starter.", false, 0, false));
        games.add(new StaticGame("Payday", "Alle spillere mottar 300 coins hver.", true, 300, false));
        games.add(new StaticGame("Payday", "[PLAYER] mottar 500 coins.", true, 500, true));
        games.add(new StaticGame("Gjeld", "[PLAYER] mister 500 coins.", true, -500, true));
        Collections.shuffle(games);
        counter = 0;
    }

    public static StaticGame getNextGame() {
        StaticGame game = games.get(counter);
        counter++;

        // shuffle array and reset counter when the end of array is reached
        if (counter == games.size()) {
            counter = 0;
            Collections.shuffle(games);
        }

        return game;
    }
}
