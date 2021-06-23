package com.example.drinkinggame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class GamePointingGameDialog  extends AppCompatDialogFragment {

    private Button buttonYes;
    private RecyclerView recyclerViewPointingGame;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_pointing_game_dialog, null);

        builder.setView(view)
                .setTitle("Choose player");

        recyclerViewPointingGame = view.findViewById(R.id.recyclerViewPointingGame);
        GamePointingGameRecyclerViewAdapter gamePointingGameRecyclerViewAdapter = new GamePointingGameRecyclerViewAdapter(this.getContext(), Players.getPlayers());
        recyclerViewPointingGame.setAdapter(gamePointingGameRecyclerViewAdapter);
        recyclerViewPointingGame.setLayoutManager(new LinearLayoutManager(this.getContext()));
        /*
        buttonYes = view.findViewById(R.id.buttonYes);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player player = Players.getRandomPlayer();
                player.setCoins(player.getCoins() + 5000);
            }
        });

         */

        return builder.create();
    }
}
