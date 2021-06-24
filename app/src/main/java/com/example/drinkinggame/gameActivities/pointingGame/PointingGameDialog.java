package com.example.drinkinggame.gameActivities.pointingGame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkinggame.MainActivity;
import com.example.drinkinggame.PlayerSelectionPhase;
import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.RecyclerViewAdapterSelectPlayer;
import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Players;

public class PointingGameDialog extends AppCompatDialogFragment {

    private RecyclerView recyclerViewPointingGame;
    private Button btnPointingGameDialogNobody;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_pointing_game_dialog, null);

        builder.setView(view);

        recyclerViewPointingGame = view.findViewById(R.id.recyclerViewCategoryGame);

        RecyclerViewAdapterSelectPlayer recyclerViewAdapterSelectPlayer = new RecyclerViewAdapterSelectPlayer(this.getContext(), Players.getPlayers(), 500);
        recyclerViewPointingGame.setAdapter(recyclerViewAdapterSelectPlayer);
        recyclerViewPointingGame.setLayoutManager(new LinearLayoutManager(this.getContext()));

        btnPointingGameDialogNobody = view.findViewById(R.id.btnPointingGameDialogNobody);
        btnPointingGameDialogNobody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;

                if (GameState.isGameOver()) intent = new Intent(getContext(), MainActivity.class);
                else intent = new Intent(getContext(), PlayerSelectionPhase.class);

                startActivity(intent);
            }
        });

        return builder.create();
    }
}
