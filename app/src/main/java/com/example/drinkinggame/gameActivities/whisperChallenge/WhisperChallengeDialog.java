package com.example.drinkinggame.gameActivities.whisperChallenge;

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
import com.example.drinkinggame.gameActivities.GamePhase;
import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Players;

public class WhisperChallengeDialog extends AppCompatDialogFragment {

    private Button btnWhisperChallengeChoice1;
    private Button btnWhisperChallengeChoice2;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_whisper_challenge_dialog, null);

        builder.setView(view);

        btnWhisperChallengeChoice1 = view.findViewById(R.id.btnWhisperChallengeChoice1);
        btnWhisperChallengeChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Players.increaseCoinsAllPlayers(100);
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        btnWhisperChallengeChoice2 = view.findViewById(R.id.btnWhisperChallengeChoice2);
        btnWhisperChallengeChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Players.increaseCoinsAllPlayers(-100);
                Intent intent = GamePhase.goToNextGame(getContext());
                startActivity(intent);
            }
        });

        return builder.create();
    }
}
