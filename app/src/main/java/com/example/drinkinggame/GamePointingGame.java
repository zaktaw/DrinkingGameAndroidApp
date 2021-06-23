package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;
import com.example.drinkinggame.models.gameCards.PointingGameAlternatives;

import java.util.ArrayList;

public class GamePointingGame extends AppCompatActivity {

    TextView textViewPointnigGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_pointing_game);

        textViewPointnigGame = findViewById(R.id.textViewPointnigGame);

        setCardText();
    }

    // replaces the placeholder ("[ALTERNATIVE]") with an actual pointing game alternative
    public void setCardText() {
        String cardText = (String) textViewPointnigGame.getText();
        String alternative = PointingGameAlternatives.getNextAlternative();

        cardText = cardText.replaceFirst("\\[ALTERNATIVE]", alternative);
        textViewPointnigGame.setText(cardText);
    }

    public void showDialog(View v) {
        GamePointingGameDialog gamePointingGameDialog = new GamePointingGameDialog();
        gamePointingGameDialog.show(getSupportFragmentManager(), "pointing game dialog");
    }
}