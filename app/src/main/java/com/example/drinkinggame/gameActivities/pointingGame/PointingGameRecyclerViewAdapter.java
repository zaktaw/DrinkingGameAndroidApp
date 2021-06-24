package com.example.drinkinggame.gameActivities.pointingGame;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drinkinggame.MainActivity;
import com.example.drinkinggame.PlayerSelectionPhase;
import com.example.drinkinggame.R;
import com.example.drinkinggame.models.GameState;
import com.example.drinkinggame.models.Player;
import com.example.drinkinggame.models.Players;

import java.util.ArrayList;

public class PointingGameRecyclerViewAdapter extends RecyclerView.Adapter<PointingGameRecyclerViewAdapter.PointingGameRecyclerViewViewHolder> {

    ArrayList<Player> players;
    Context context;

    public PointingGameRecyclerViewAdapter(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
    }

    @NonNull
    @Override
    public PointingGameRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_pointing_game_recycler_view_row, parent, false);
        return new PointingGameRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PointingGameRecyclerViewViewHolder holder, int position) {
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

    public class PointingGameRecyclerViewViewHolder extends RecyclerView.ViewHolder{

        TextView pointingGameRecyclerViewPlayer;
        ConstraintLayout pointingGameRecyclerViewRow;

        public PointingGameRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            pointingGameRecyclerViewPlayer = itemView.findViewById(R.id.pointingGameRecyclerVeiwPlayer);
            pointingGameRecyclerViewRow = itemView.findViewById(R.id.pointingGameRecyclerViewRow);
        }
    }
}
