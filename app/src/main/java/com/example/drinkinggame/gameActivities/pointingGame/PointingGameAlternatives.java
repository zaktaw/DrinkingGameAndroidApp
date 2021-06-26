package com.example.drinkinggame.gameActivities.pointingGame;

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
        this.alternatives.add("er mest sannsynlig til å bli berømt");
        this.alternatives.add("er mest sannsynlig til å sluppe unna med mord");
        this.alternatives.add("er mest lykkelig");
        this.alternatives.add("er mest kreativ");
        this.alternatives.add("er den største overtenkeren");
        this.alternatives.add("er mest sannsynlig til å sette en verdensrekord");
        this.alternatives.add("er mest sannsynlig til å bli rik");
        this.alternatives.add("er mest sannsynlig til å bli en hersker over verden");
        this.alternatives.add("er mest sannsynlig til å bli en bonde");
        this.alternatives.add("er mest sannsynlig til å dø av en tåpelig grunn");
        this.alternatives.add("er mest sannsynlig til å bli en stand-up-komiker");
        this.alternatives.add("er mest sannsynlig til å bruke alle pengene deres på noe dumt");
        this.alternatives.add("er mest sannsynlig til å være oppe hele natta for å krangle med nett-troll");
        this.alternatives.add("er den dårligste skuespilleren");
        this.alternatives.add("er mest sannsynlig til å havne i fengsel for noe dumt");
        this.alternatives.add("er mest sannsynlig til å bli deltaker i et reality-show");
        this.alternatives.add("er mest sannsynlig til å dra på en blind-date arrangert av moren deres");
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
