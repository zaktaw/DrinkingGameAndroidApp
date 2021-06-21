package com.example.drinkinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.drinkinggame.models.Players;

public class MainActivity extends AppCompatActivity {

    public Players players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        players = new Players();
        Log.d("players", "Instansiated players");
    }

    public void goToAddPlayers(View v) {
        Intent intent = new Intent(this, AddPlayers.class);
        startActivity(intent);
    }
}