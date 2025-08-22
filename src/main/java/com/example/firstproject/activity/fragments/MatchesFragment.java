package com.example.firstproject.activity.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstproject.R;
import com.example.firstproject.activity.adapter.MatchesAdapter;
import com.example.firstproject.activity.models.MatchItem;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {


    ListView listEnglish, listSpanish;
    MatchesAdapter englishAdapter, spanishAdapter;
    ArrayList<MatchItem> englishMatches, spanishMatches;

    public MatchesFragment() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        listEnglish = view.findViewById(R.id.listEnglishLeague);
        listSpanish = view.findViewById(R.id.listSpanishLeague);

        // إنشاء قائمة مباريات تجريبية

        // بيانات الدوري الإنجليزي
        englishMatches = new ArrayList<>();
        englishMatches.add(new MatchItem("ليفربول", R.drawable.team_o, "أرسنال", R.drawable.team_t, "15:00"));
        englishMatches.add(new MatchItem("مانشستر يونايتد", R.drawable.team_th, "تشيلسي", R.drawable.team_f, "17:00"));
        englishMatches.add(new MatchItem("مانشستر سيتي", R.drawable.team_fi, "توتنهام", R.drawable.team_s, "19:00"));
        englishMatches.add(new MatchItem("ليفربول", R.drawable.team_o, "أرسنال", R.drawable.team_t, "15:00"));

        // بيانات الدوري الإسباني
        spanishMatches = new ArrayList<>();
        spanishMatches.add(new MatchItem("برشلونة", R.drawable.team_se, "ريال مدريد", R.drawable.team_e, "17:00"));
        spanishMatches.add(new MatchItem("أتليتيكو مدريد", R.drawable.team_n, "خيتافي", R.drawable.team_tt, "17:00"));
        spanishMatches.add(new MatchItem("إشبيلية", R.drawable.team_l, "ريال سوسيداد", R.drawable.team_z, "17:00"));
        spanishMatches.add(new MatchItem("برشلونة", R.drawable.team_se, "ريال مدريد", R.drawable.team_e, "17:00"));


        englishAdapter = new MatchesAdapter(getContext(), englishMatches);
        spanishAdapter = new MatchesAdapter(getContext(), spanishMatches);

        listEnglish.setAdapter(englishAdapter);
        listSpanish.setAdapter(spanishAdapter);

        listEnglish.setOnItemClickListener((parent, view1, position, id) -> {
            MatchItem match = englishMatches.get(position);
            Toast.makeText(getContext(),
                    "اخترت المباراة: " + match.getTeam1() + " vs " + match.getTeam2(),
                    Toast.LENGTH_SHORT).show();
        });

        listSpanish.setOnItemClickListener((parent, view12, position, id) -> {
            MatchItem match = spanishMatches.get(position);
            Toast.makeText(getContext(),
                    "اخترت المباراة: " + match.getTeam1() + " vs " + match.getTeam2(),
                    Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
