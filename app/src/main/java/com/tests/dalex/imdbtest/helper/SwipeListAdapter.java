package com.tests.dalex.imdbtest.helper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.tests.dalex.imdbtest.R;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by dalex on 9/10/2015.
 */
public class SwipeListAdapter extends RecyclerView.Adapter<SwipeListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mTitle;
        public TextView mContent;
        public ViewHolder(View v)
        {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.serial);
            mContent = (TextView) v.findViewById(R.id.title);

        }
    }

    private Activity activity;
    private List<Movie> movieList;
    private String[] bgColors;

    public SwipeListAdapter(Activity activity, List<Movie> movieList)
    {
        this.activity = activity;
        this.movieList = movieList;
        bgColors = activity.getApplication().getResources().getStringArray(R.array.movie_serial_bg);
    }

    @Override
    public SwipeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTitle.setText(String.valueOf(movieList.get(position).id));
        viewHolder.mContent.setText(String.valueOf(movieList.get(position).title));

        String color = bgColors[position % bgColors.length];
        viewHolder.mTitle.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
