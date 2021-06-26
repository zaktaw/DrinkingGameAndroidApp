package com.example.drinkinggame.gameActivities.charadesGame;

import java.util.ArrayList;
import java.util.Collections;


public class CharadesGameAlternatives {
    private static ArrayList<String> alternatives;
    private static int counter;

    public CharadesGameAlternatives() {
        this.alternatives = new ArrayList<>();
        this.alternatives.add("en full person");
        this.alternatives.add("en stripper");
        this.alternatives.add("en vekter");
        this.alternatives.add("et spøkelse");
        this.alternatives.add("en ballong");
        this.alternatives.add("et monster");
        this.alternatives.add("en banan");
        this.alternatives.add("en trampoline");
        this.alternatives.add("en hval");
        this.alternatives.add("basketball");
        this.alternatives.add("en klovn");
        this.alternatives.add("en lyspære");
        this.alternatives.add("et helikopter");
        Collections.shuffle(alternatives);
        counter = 0;
    }

    public static String getNextAlternative() {
        String alternative = alternatives.get(counter);
        counter++;

        // shuffle array and reset counter when the end of array is reached
        if (counter == alternatives.size()) {
            counter = 0;
            Collections.shuffle(alternatives);
        }

        return alternative;
    }
}
