package com.example.drinkinggame;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

import java.util.ArrayList;

public class GamePointingGameRecyclerViewAdapter extends RecyclerView.Adapter<GamePointingGameRecyclerViewAdapter.GamePointingGameRecyclerViewViewHolder> {

    ArrayList<Player> players;
    Context context;

    public GamePointingGameRecyclerViewAdapter(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public GamePointingGameRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pointing_game_recycler_view_row, parent, false);
        return new GamePointingGameRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamePointingGameRecyclerViewAdapter.GamePointingGameRecyclerViewViewHolder holder, int position) {
        holder.pointingGameRecyclerViewPlayer.setText(players.get(position).getName());

        // when a player is clicked: increase their coins and go to player selection phase
        holder.pointingGameRecyclerViewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;

                if (GameState.isGameOver()) intent = new Intent(context, MainActivity.class);
                else intent = new Intent(context, PlayerSelectionPhase.class);

                Player player = Players.getPlayerByName(players.get(position).getName());
                player.setCoins(player.getCoins() + 5000);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class GamePointingGameRecyclerViewViewHolder extends RecyclerView.ViewHolder{

        TextView pointingGameRecyclerViewPlayer;
        ConstraintLayout pointingGameRecyclerViewRow;

        public GamePointingGameRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            pointingGameRecyclerViewPlayer = itemView.findViewById(R.id.pointingGameRecyclerVeiwPlayer);
            pointingGameRecyclerViewRow = itemView.findViewById(R.id.pointingGameRecyclerViewRow);
        }
    }
}
