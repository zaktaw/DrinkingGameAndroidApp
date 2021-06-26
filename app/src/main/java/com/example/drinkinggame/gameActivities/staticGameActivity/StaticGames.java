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
        games.add(new StaticGame("Payday", "Alle spillere tar en gruppeskål og mottar 300 coins hver.", true, 300, false));
        games.add(new StaticGame("Payday", "Alle spillere tar en gruppeskål og mottar 300 coins hver.", true, 300, false));
        games.add(new StaticGame("Payday", "[PLAYER] mottar 500 coins.", true, 500, true));
        games.add(new StaticGame("Payday", "[PLAYER] mottar 500 coins.", true, 500, true));
        games.add(new StaticGame("Gjeld", "[PLAYER] mister 500 coins.", true, -500, true));
        games.add(new StaticGame("Gjeld", "[PLAYER] mister 500 coins.", true, -500, true));
        games.add(new StaticGame("Bursdag", "Alle sier bursdagsmåneden til spilleren til venstre for seg. Drikk tre slurker om du sier feil måned. [PLAYER] starter.", false, 0, false));
        games.add(new StaticGame("Jeg har aldri", "Hver spiller sier noe de aldri har gjort. Spillere som har gjort dette drikker en slurk. [PLAYER] starter.", false, 0, false));
        games.add(new StaticGame("Waterfall", "Alle spillere begynner å chugge drikken sin. [PLAYER] kan velge når h*n vil slutte. Når [PLAYER] har avsluttet kan spilleren til høyre for [PLAYER] velge å avslutte. Dette fortsetter til ingen drikker lenger.",false, 0, false));
        games.add(new StaticGame("Bølgen", "[PLAYER] drikker en slurk. Spilleren til høyre tar to slurker, den neste spilleren tar tre slurker og så videre helt til alle har drukket.",false, 0, false));
        games.add(new StaticGame("Navnrunde", "[PLAYER] må si det fulle navnet til hver deltaker. Drikk en slurk for hvert navn du ikke klarer og del ut en slurk for hvert navn du klarer.",false, 0, false));
        games.add(new StaticGame("Singles", "Alle single spillere skåler",false, 0, false));
        games.add(new StaticGame("Første gangen", "Hvis dette er første gangen du spiller YAPA!, ta en slurk.",false, 0, false));
        games.add(new StaticGame("Pensjonist", "Den eldste spilleren tar en slurk.",false, 0, false));
        games.add(new StaticGame("Baby", "Den yngste spilleren tar en slurk.",false, 0, false));
        games.add(new StaticGame("ØL", "Alle som drikker øl tar en slurk.",false, 0, false));
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
