package com.example.drinkinggame.gameActivities.categoryGame;

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

public class CategoryGameDialog extends AppCompatDialogFragment {

    private RecyclerView recyclerViewCategoryGame;
    private Button btnCategoryGameDialogNobody;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_category_game_dialog, null);

        builder.setView(view);

        recyclerViewCategoryGame = view.findViewById(R.id.recyclerViewCategoryGame);

        RecyclerViewAdapterSelectPlayer recyclerViewAdapterSelectPlayer = new RecyclerViewAdapterSelectPlayer(this.getContext(), Players.getPlayers(), -500);
        recyclerViewCategoryGame.setAdapter(recyclerViewAdapterSelectPlayer);
        recyclerViewCategoryGame.setLayoutManager(new LinearLayoutManager(this.getContext()));

        btnCategoryGameDialogNobody = view.findViewById(R.id.btnCategoryGameDialogNobody);
        btnCategoryGameDialogNobody.setOnClickListener(new View.OnClickListener() {
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
