package com.example.drinkinggame.models.gameCards;

import java.util.ArrayList;
import java.util.Collections;


public class PointingGameAlternatives {
    private static ArrayList<String> alternatives;
    private static int counter;

    public PointingGameAlternatives() {
        this.alternatives = new ArrayList<>();
        this.alternatives.add("har drukket mest");
        this.alternatives.add("har drukket minst");
        this.alternatives.add("er smartest");
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
