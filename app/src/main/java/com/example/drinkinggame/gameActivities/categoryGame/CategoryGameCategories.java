package com.example.drinkinggame.gameActivities.categoryGame;

import java.util.ArrayList;
import java.util.Collections;

public class CategoryGameCategories {
    private static ArrayList<String> categories;
    private static int counter;

    public CategoryGameCategories() {
        this.categories = new ArrayList<>();
        this.categories.add("drinker");
        this.categories.add("fotball-klubber");
        this.categories.add("øl-merker");
        Collections.shuffle(categories);
        counter = 0;
    }

    public static String getNextCategory() {
        String category = categories.get(counter);
        counter++;

        // shuffle array and reset counter when the end of array is reached
        if (counter == categories.size()) {
            counter = 0;
            Collections.shuffle(categories);
        }

        return category;
    }
}
