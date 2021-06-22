package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Players;
import com.example.drinkinggame.models.ShopObject;
import com.example.drinkinggame.models.ShopObjects;
import com.example.drinkinggame.models.gameCards.CategoryGame;
import com.example.drinkinggame.models.gameCards.GameCard;
import com.example.drinkinggame.models.gameCards.GameCards;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public Players players;
    public ShopObjects shopObjects;
    public GameCards gameCards;
    public GameState gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameState = new GameState(3);

        players = new Players();
        Log.d("players", "Instansiated players");

        shopObjects = new ShopObjects();
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_1), 200));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_2), 300));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_3), 400));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_4), 500));
        ShopObjects.addShopObject(new ShopObject(getString(R.string.shop_object_5), 600));

        gameCards = new GameCards();
        gameCards.addGameCard(new CategoryGame(
                getString(R.string.game_card_1_title),
                new ArrayList<String>(Arrays.asList(getString(R.string.game_card_1_page1), getString(R.string.game_card_1_page2))),
                1
        ));

        gameCards.addGameCard(new CategoryGame(
                getString(R.string.game_card_2_title),
                new ArrayList<String>(Arrays.asList(getString(R.string.game_card_2_page1), getString(R.string.game_card_2_page2))),
                3
        ));
    }

    public void goToAddPlayers(View v) {
        Intent intent = new Intent(this, AddPlayers.class);
        startActivity(intent);
    }
}