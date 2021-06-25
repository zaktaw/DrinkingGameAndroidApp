package com.example.drinkinggame.gameActivities.humSong;

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
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

public class HumSongDialog2 extends AppCompatDialogFragment {

    private RecyclerView recyclerViewHumSong;
    private Button btnHumSongSkip2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_hum_song_dialog2, null);

        builder.setView(view);

        recyclerViewHumSong = view.findViewById(R.id.recyclerViewHumSong);

        RecyclerViewAdapterSelectPlayer recyclerViewAdapterSelectPlayer = new RecyclerViewAdapterSelectPlayer(this.getContext(), Players.getPlayers(), 300);
        recyclerViewHumSong.setAdapter(recyclerViewAdapterSelectPlayer);
        recyclerViewHumSong.setLayoutManager(new LinearLayoutManager(this.getContext()));

        btnHumSongSkip2 = view.findViewById(R.id.btnHumSongSkip2);
        btnHumSongSkip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        return builder.create();
    }
}
