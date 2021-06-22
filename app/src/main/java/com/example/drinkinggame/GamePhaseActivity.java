package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.gameCards.GameCard;
import com.example.drinkinggame.models.gameCards.GameCards;

public class GamePhaseActivity extends AppCompatActivity {

    TextView textViewGameCard;

    int pageConter = 0;
    GameCard currentGameCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_phase);

        textViewGameCard = findViewById(R.id.textViewGameCard);

        //  get a random game card and display its first page
        currentGameCard = GameCards.getRandomGameCard();
        textViewGameCard.setText(currentGameCard.getPages().get(pageConter));
    }

    public void nextPage(View v) {
        pageConter++;

        // go to next game card if there aren't any more pages left in current game card
        if (pageConter == currentGameCard.getPages().size()) {
            Intent intent = new Intent(this, GamePhaseActivity.class);
            startActivity(intent);
        }
        else {
            textViewGameCard.setText(currentGameCard.getPages().get(pageConter));
        }
    }
}