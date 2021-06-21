package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;
import com.example.drinkinggame.models.ShopObject;
import com.example.drinkinggame.models.ShopObjects;

import java.util.ArrayList;
import java.util.Collections;

public class ShopPhase extends AppCompatActivity {

    TextView shopPhaseCurrentPlayer;
    Button btnShopObject1;
    Button btnShopObject2;
    Button btnShopObject3;

    ShopObject shopObject1;
    ShopObject shopObject2;
    ShopObject shopObject3;
    int currentPlayerIndex;
    Player currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_phase);

        shopPhaseCurrentPlayer = findViewById(R.id.shopPhaseCurrentPlayer);
        btnShopObject1 = findViewById(R.id.btnShopObject1);
        btnShopObject2 = findViewById(R.id.btnShopObject2);
        btnShopObject3 = findViewById(R.id.btnShopObject3);

        // get current player and update text view for current player
        Intent intent = getIntent();
        currentPlayerIndex = intent.getIntExtra("currentPlayer", 0);
        currentPlayer = Players.getPlayers().get(currentPlayerIndex);
        shopPhaseCurrentPlayer.setText(currentPlayer.getName() + " (coins: " + currentPlayer.getCoins() + ")");
        Log.d("currentPlayer", "Got current player: " + currentPlayer.getName() + " (coins: " + currentPlayer.getCoins() + ")");

        updateShopObjects();
    }

    public void updateShopObjects() {
        ArrayList<ShopObject> shopObjects = ShopObjects.getShopObjects();
        Collections.shuffle(shopObjects);
        shopObject1 = shopObjects.get(0);
        shopObject2 = shopObjects.get(1);
        shopObject3 = shopObjects.get(2);

        btnShopObject1.setText(shopObject1.getDescription() + "\nPris: " + shopObject1.getPrice());
        btnShopObject2.setText(shopObject2.getDescription() + "\nPris: " + shopObject2.getPrice());
        btnShopObject3.setText(shopObject3.getDescription() + "\nPris: " + shopObject3.getPrice());
    }

    public void purchaseShopObject(View v) {
        ShopObject objectToPurchase = ShopObjects.getShopObjects().get(Integer.parseInt((String) v.getTag())); // use tag assosiated with shop object-button to purchase the correct object

        // check if player has enough coins to purchase the object
        if (objectToPurchase.getPrice() > currentPlayer.getCoins()) {
            Toast.makeText(this, R.string.error_insufficient_funds, Toast.LENGTH_LONG).show();
            return;
        }

        // disable button and update player's coins
        v.setEnabled(false);
        currentPlayer.setCoins(currentPlayer.getCoins() - objectToPurchase.getPrice());
        shopPhaseCurrentPlayer.setText(currentPlayer.getName() + " (coins: " + currentPlayer.getCoins() + ")");
    }
}