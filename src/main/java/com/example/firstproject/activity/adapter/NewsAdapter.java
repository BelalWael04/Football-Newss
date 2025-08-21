package com.example.firstproject.activity.adapter;

import com.example.firstproject.R;
import com.example.firstproject.activity.models.NewsItem; // أو المسار الصحيح حسب مكان الكلاس

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class NewsAdapter extends BaseAdapter {

    Context context;
    ArrayList<NewsItem> newsList;
    LayoutInflater inflater;

    public NewsAdapter(Context context, ArrayList<NewsItem> newsList) {
        this.context = context;
        this.newsList = newsList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        ImageView imgNews;
        TextView txtTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.news_list_item, parent, false);
            holder = new ViewHolder();
            holder.imgNews = convertView.findViewById(R.id.img_news);
            holder.txtTitle = convertView.findViewById(R.id.txt_news_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        NewsItem item = newsList.get(position);
        holder.imgNews.setImageResource(item.getImageResId());
        holder.txtTitle.setText(item.getTitle());

        return convertView;
    }

}
