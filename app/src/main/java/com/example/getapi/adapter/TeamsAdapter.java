package com.example.getapi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getapi.R;
import com.example.getapi.TeamsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {

    Context context;
    List<TeamsItem> data;

    public TeamsAdapter(Context context, List<TeamsItem> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TeamsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_teams, null));
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder teamsViewHolder, final int i) {
        teamsViewHolder.tvClubName.setText(data.get(i).getStrTeam());
        teamsViewHolder.tvNameStadium.setText(data.get(i).getStrStadium());

        Picasso.get().load(data.get(i).getStrStadiumThumb()).into(teamsViewHolder.imgStadium);
        Picasso.get().load(data.get(i).getStrTeamBadge()).into(teamsViewHolder.imgClub);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TeamsViewHolder extends RecyclerView.ViewHolder {

        TextView tvClubName, tvNameStadium;
        ImageView imgClub, imgStadium;

        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvClubName = itemView.findViewById(R.id.tv_club_name);
            tvNameStadium = itemView.findViewById(R.id.tv_stadium_name);
            imgClub = itemView.findViewById(R.id.img_club);
            imgStadium = itemView.findViewById(R.id.img_stadium);

        }
    }
}
