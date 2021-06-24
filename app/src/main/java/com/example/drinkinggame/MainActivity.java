package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.drinkinggame.gameActivities.categoryGame.CategoryGameCategories;
import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Players;
import com.example.drinkinggame.models.ShopObject;
import com.example.drinkinggame.models.ShopObjects;
import com.example.drinkinggame.gameActivities.pointingGame.PointingGameAlternatives;

public class MainActivity extends AppCompatActivity {

    public Players players;
    public ShopObjects shopObjects;
    public GameState gameState;
    public PointingGameAlternatives pointingGameAlternatives;
    public CategoryGameCategories categoryGameCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameState = new GameState();
        pointingGameAlternatives = new PointingGameAlternatives();
        categoryGameCategories = new CategoryGameCategories();

        players = new Players();
        Log.d("players", "Instansiated players");

        shopObjects = new ShopObjects();
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_1), 200));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_2), 300));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_3), 400));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_4), 500));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_5), 600));

        gameState.addGameCard("WhisperChallenge");
        gameState.addGameCard("PointingGame");
        gameState.addGameCard("CategoryGame");
        gameState.addGameCard("CategoryGame");
        GameState.shuffleGameCards();
    }

    public void goToAddPlayers(View v) {
        Intent intent = new Intent(this, AddPlayers.class);
        startActivity(intent);
    }
}