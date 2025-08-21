package com.example.firstproject.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstproject.R;
import com.example.firstproject.activity.models.MatchItem;

import java.util.ArrayList;

public class MatchesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MatchItem> matchesList;

    public MatchesAdapter(Context context, ArrayList<MatchItem> matchesList) {
        this.context = context;
        this.matchesList = matchesList;
    }

    @Override
    public int getCount() {
        return matchesList.size();
    }

    @Override
    public Object getItem(int position) {
        return matchesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView team1Logo, team2Logo;
        TextView team1Name, team2Name, matchTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(context).inflate(R.layout.match_item_layout, parent, false);
        }

        MatchItem match = matchesList.get(position);

        ImageView team1Logo = row.findViewById(R.id.team1_logo);
        ImageView team2Logo = row.findViewById(R.id.team2_logo);
        TextView team1Name = row.findViewById(R.id.team1_name);
        TextView team2Name = row.findViewById(R.id.team2_name);
        TextView matchTime = row.findViewById(R.id.match_time);

        team1Logo.setImageResource(match.getTeam1LogoRes());
        team2Logo.setImageResource(match.getTeam2LogoRes());
        team1Name.setText(match.getTeam1());
        team2Name.setText(match.getTeam2());
        matchTime.setText(match.getMatchTime());

        return row;
    }
}
