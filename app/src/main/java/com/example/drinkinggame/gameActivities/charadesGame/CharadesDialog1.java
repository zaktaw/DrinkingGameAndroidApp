package com.example.drinkinggame.gameActivities.charadesGame;

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
import com.example.drinkinggame.gameActivities.humSong.HumSongDialog2;
import com.example.drinkinggame.models.Player;

public class CharadesDialog1 extends AppCompatDialogFragment {

    private Button btnCharadesYes;
    private Button btnCharadesNo;
    private Button btnCharadesSkip;
    private Player player;

    public CharadesDialog1(Player player) {
        this.player = player;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_charades_game_dialog, null);

        builder.setView(view);

        btnCharadesYes = view.findViewById(R.id.btnCharadesYes);
        btnCharadesYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.giveCoins(500);
                CharadesDialog2 charadesDialog2 = new CharadesDialog2();
                charadesDialog2.show(getFragmentManager(),"charades dialog2");
            }
        });

        btnCharadesNo = view.findViewById(R.id.btnCharadesNo);
        btnCharadesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.giveCoins(-200);
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        btnCharadesSkip = view.findViewById(R.id.btnCharadesSkip);
        btnCharadesSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        return builder.create();
    }
}
