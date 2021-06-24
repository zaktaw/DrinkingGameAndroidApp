package com.example.drinkinggame.gameActivities.categoryGame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.drinkinggame.R;
import com.example.drinkinggame.models.Players;

public class CategoryGame extends AppCompatActivity {

    private TextView textViewCategoryGameDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_game);

        textViewCategoryGameDescription = findViewById(R.id.textViewCategoryGameDescription);
        setCardText();
    }

    // replaces the placeholders ([CATEGORY], [PLAYER]) with an actual category and a random player
    public void setCardText() {
        String cardText = (String) textViewCategoryGameDescription.getText();
        String category = CategoryGameCategories.getNextCategory();
        String player = Players.getRandomPlayer().getName();

        cardText = cardText.replaceAll("\\[CATEGORY]", category);
        cardText = cardText.replaceAll("\\[PLAYER]", player);
        textViewCategoryGameDescription.setText(cardText);
    }

    public void showDialog(View v) {
        CategoryGameDialog categoryGameDialog = new CategoryGameDialog();
        categoryGameDialog.show(getSupportFragmentManager(), "category game dialog");
    }
}