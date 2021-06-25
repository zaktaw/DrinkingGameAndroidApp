package com.example.drinkinggame.gameActivities.charadesGame;

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

import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.GamePhase;
import com.example.drinkinggame.gameActivities.RecyclerViewAdapterSelectPlayer;
import com.example.drinkinggame.models.Players;

public class CharadesDialog2 extends AppCompatDialogFragment {

    private RecyclerView recyclerViewCharades;
    private Button btnCharadesSkip2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_charades_dialog2, null);

        builder.setView(view);

        recyclerViewCharades = view.findViewById(R.id.recyclerViewCharades);

        RecyclerViewAdapterSelectPlayer recyclerViewAdapterSelectPlayer = new RecyclerViewAdapterSelectPlayer(this.getContext(), Players.getPlayers(), 500);
        recyclerViewCharades.setAdapter(recyclerViewAdapterSelectPlayer);
        recyclerViewCharades.setLayoutManager(new LinearLayoutManager(this.getContext()));

        btnCharadesSkip2 = view.findViewById(R.id.btnCharadesSkip2);
        btnCharadesSkip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        return builder.create();
    }
}
