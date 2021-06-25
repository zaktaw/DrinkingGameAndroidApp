package com.example.drinkinggame.gameActivities.charadesGame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.humSong.HumSongDialog1;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class CharadesGame extends AppCompatActivity {

    private TextView textViewCharadesDescription;
    private Player player;
    private boolean screenClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charades_game);

        player = Players.getRandomPlayer();
        textViewCharadesDescription = findViewById(R.id.textViewCharadesDescription);
        setText();
    }

    // first time screen is clicked: change description text.
    // second time screen is clicked: show dialog
    public void handleClick(View v) {
        if (screenClicked) {
            CharadesDialog1 charadesDialog1 = new CharadesDialog1(player);
            charadesDialog1.show(getSupportFragmentManager(), "charades dialog");
        }
        else {
            String charadesAlternative = CharadesGameAlternatives.getNextAlternative();
            String cardText = getString(R.string.charades_game_description2);
            cardText = cardText.replaceAll("\\[ALTERNATIVE]", charadesAlternative);
            textViewCharadesDescription.setText(cardText);
            screenClicked = true;
        }

    }

    private void setText() {
        String cardText = (String) textViewCharadesDescription.getText();
        cardText = cardText.replaceAll("\\[PLAYER]", player.getName());
        textViewCharadesDescription.setText(cardText);
    }
}