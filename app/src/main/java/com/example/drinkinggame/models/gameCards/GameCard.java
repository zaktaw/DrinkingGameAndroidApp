package com.example.drinkinggame.models.gameCards;

import android.util.Log;

import java.util.ArrayList;

public class GameCard {
    String title;
    ArrayList<String> pages;
    int playersInvolved;

    public GameCard(String title, ArrayList<String> pages, int playersInvolved) {
        this.title = title;
        this.pages = pages;
        this.playersInvolved = playersInvolved;
    }


    public void action() {
        Log.d("GameCard", "Hello from GameCard");
    }

    public ArrayList<String> getPages() {
        return pages;
    }

    public void setPages(ArrayList<String> pages) {
        this.pages = pages;
    }

    public int getPlayersInvolved() {
        return playersInvolved;
    }

    public void setPlayersInvolved(int playersInvolved) {
        this.playersInvolved = playersInvolved;
    }
}
