package com.example.drinkinggame.gameActivities.pointingGame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.R;

public class PointingGame extends AppCompatActivity {

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

        cardText = cardText.replaceAll("\\[ALTERNATIVE]", alternative);
        textViewPointnigGame.setText(cardText);
    }

    public void showDialog(View v) {
        PointingGameDialog pointingGameDialog = new PointingGameDialog();
        pointingGameDialog.show(getSupportFragmentManager(), "pointing game dialog");
    }
}