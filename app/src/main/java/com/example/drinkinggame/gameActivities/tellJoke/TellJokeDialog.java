package com.example.drinkinggame.gameActivities.tellJoke;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.GamePhase;
import com.example.drinkinggame.gameActivities.RecyclerViewAdapterSelectPlayer;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class TellJokeDialog extends AppCompatDialogFragment {

    private Button btnTellJokeYes;
    private Button btnTellJokeNo;
    private Button btnTellJokeSkip;
    private Player player;

    public TellJokeDialog(Player player) {
        this.player = player;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_tell_joke_dialog, null);

        builder.setView(view);

        btnTellJokeYes = view.findViewById(R.id.btnTellJokeYes);
        btnTellJokeYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.giveCoins(300);
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        btnTellJokeNo = view.findViewById(R.id.btnTellJokeNo);
        btnTellJokeNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.giveCoins(-300);
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        btnTellJokeSkip = view.findViewById(R.id.btnTellJokeSkip);
        btnTellJokeSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        return builder.create();
    }
}
