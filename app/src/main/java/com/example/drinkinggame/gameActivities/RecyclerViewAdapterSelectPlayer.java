package com.example.drinkinggame.gameActivities;
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

public class RecyclerViewAdapterSelectPlayer extends RecyclerView.Adapter<RecyclerViewAdapterSelectPlayer.SelectPlayerViewHolder> {

    ArrayList<Player> players;
    Context context;
    int ammount; // ammout of coins to give player

    public RecyclerViewAdapterSelectPlayer(Context context, ArrayList<Player> players, int ammount) {
        this.context = context;
        this.players = players;
        this.ammount = ammount;
    }

    @NonNull
    @Override
    public SelectPlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_select_player_recycler_view_row, parent, false);
        return new SelectPlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectPlayerViewHolder holder, int position) {
        holder.textViewPlayer.setText(players.get(position).getName());

        // when a player is clicked: increase their coins and go to player selection phase
        holder.selectPlayerRecyclerViewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;

                if (GameState.isGameOver()) intent = new Intent(context, MainActivity.class);
                else intent = new Intent(context, PlayerSelectionPhase.class);

                Player player = Players.getPlayerByName(players.get(position).getName());
                player.setCoins(player.getCoins() + ammount);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class SelectPlayerViewHolder extends RecyclerView.ViewHolder{

        TextView textViewPlayer;
        ConstraintLayout selectPlayerRecyclerViewRow;

        public SelectPlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPlayer = itemView.findViewById(R.id.textViewPlayer);
            selectPlayerRecyclerViewRow = itemView.findViewById(R.id.selectPlayerRecyclerViewRow);
        }
    }
}
