package com.example.firstproject.activity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firstproject.R;
import com.example.firstproject.activity.adapter.NewsAdapter;
import com.example.firstproject.activity.models.NewsItem;

import java.util.ArrayList;


public class NewsFragment extends Fragment {


    private ListView listView;
    private NewsAdapter adapter;
    private ArrayList<NewsItem> newsList;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);

        listView = view.findViewById(R.id.list_news);

        // بيانات تجريبية للأخبار
        newsList = new ArrayList<>();
        newsList.add(new NewsItem("مانشستر سيتي يعلن عن صفقة جديدة", R.drawable.one));
        newsList.add(new NewsItem("برشلونة تواجه تحديات مالية", R.drawable.two));
        newsList.add(new NewsItem("ليفربول يستعد لمباراة ودية", R.drawable.three));
        newsList.add(new NewsItem("باريس سان جيرمان يستعد للموسم الجديد", R.drawable.four));
        newsList.add(new NewsItem("برشلونة تواجه تحديات مالية", R.drawable.two));
        newsList.add(new NewsItem("ليفربول يستعد لمباراة ودية", R.drawable.three));
        newsList.add(new NewsItem("باريس سان جيرمان يستعد للموسم الجديد", R.drawable.four));

        adapter = new NewsAdapter(getContext(), newsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            NewsItem clicked = newsList.get(position);
            Toast.makeText(getContext(), "اخترت الخبر: " + clicked.getTitle(), Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}