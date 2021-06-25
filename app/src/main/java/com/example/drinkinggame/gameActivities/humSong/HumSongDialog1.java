package com.example.drinkinggame.gameActivities.humSong;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.drinkinggame.R;
import com.example.drinkinggame.gameActivities.GamePhase;
import com.example.drinkinggame.gameActivities.tellJoke.TellJokeDialog;
import com.example.drinkinggame.models.Player;

public class HumSongDialog1 extends AppCompatDialogFragment {

    private Button btnHumSongYes;
    private Button btnHumSongNo;
    private Button btnHumSongSkip;
    private Player player;

    public HumSongDialog1(Player player) {
        this.player = player;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_hum_song_dialog, null);

        builder.setView(view);

        btnHumSongYes = view.findViewById(R.id.btnHumSongYes);
        btnHumSongYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.giveCoins(300);
                HumSongDialog2 humSongDialog2 = new HumSongDialog2();
                humSongDialog2.show(getFragmentManager(),"tell joke dialog");
            }
        });

        btnHumSongNo = view.findViewById(R.id.btnHumSongNo);
        btnHumSongNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.giveCoins(-300);
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        btnHumSongSkip = view.findViewById(R.id.btnHumSongSkip);
        btnHumSongSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        return builder.create();
    }
}
