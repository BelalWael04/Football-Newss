package com.example.firstproject.activity.fragments;
import com.example.firstproject.activity.adapter.MatchesAdapter;
import com.example.firstproject.activity.adapter.NewsAdapter;
import com.example.firstproject.activity.models.MatchItem;
import com.example.firstproject.activity.models.NewsItem;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstproject.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView newsListView, matchesListView;
    NewsAdapter newsAdapter;
    MatchesAdapter matchesAdapter;
    ArrayList<NewsItem> newsList;
    ArrayList<MatchItem> matchesList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout
        View view = inflater.inflate(R.layout.fragment_home, container, false);

         newsListView  = view.findViewById(R.id.list_news);
         matchesListView = view.findViewById(R.id.list_matches);

        // بيانات الأخبار
        newsList = new ArrayList<>();
        newsList.add(new NewsItem("مانشستر سيتي يعلن عن صفقة جديدة", R.drawable.one));
        newsList.add(new NewsItem("برشلونة تواجه تحديات مالية", R.drawable.two));
        newsList.add(new NewsItem("ليفربول يستعد لمباراة ودية", R.drawable.three));
        newsAdapter = new NewsAdapter(getContext(), newsList);
        newsListView.setAdapter(newsAdapter);

        newsListView.setOnItemClickListener((parent, v, position, id) -> {
            NewsItem item = newsList.get(position);
            Toast.makeText(getContext(), "اخترت الخبر: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        });

        // بيانات المباريات
        matchesList = new ArrayList<>();
        matchesList.add(new MatchItem("ليفربول", R.drawable.team_o, "أرسنال", R.drawable.team_t, "15:00"));
        matchesList.add(new MatchItem("مانشستر يونايتد", R.drawable.team_th, "تشيلسي", R.drawable.team_f, "17:00"));
        matchesList.add(new MatchItem("مانشستر سيتي", R.drawable.team_fi, "توتنهام", R.drawable.team_s, "19:00"));
        matchesList.add(new MatchItem("برشلونة", R.drawable.team_se, "ريال مدريد", R.drawable.team_e, "17:00"));
        matchesList.add(new MatchItem("اتلتيكو مدريد", R.drawable.team_n, "خيتافي", R.drawable.team_tt, "17:00"));
        matchesList.add(new MatchItem("اشبيلية", R.drawable.team_l, "ريال سوسيداد", R.drawable.team_z, "17:00"));

        matchesAdapter = new MatchesAdapter(getContext(), matchesList);
        matchesListView.setAdapter(matchesAdapter);

        matchesListView.setOnItemClickListener((parent, v, position, id) -> {
            MatchItem match = matchesList.get(position);
            Toast.makeText(getContext(), "اخترت المباراة: " + match.getTeam1() + " vs " + match.getTeam2(),
                    Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
