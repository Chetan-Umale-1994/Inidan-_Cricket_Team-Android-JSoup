package com.example.abc.inidancricketteam;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomIconLabelAdapter extends ArrayAdapter {
    Context context;

    String[] names;
    String[] roles;
    Integer[] images;

    public CustomIconLabelAdapter(Context context, int layoutToBeInflated,
                                  String[] names, String[] roles, Integer[] images) {
        super(context, R.layout.player_item, names);
        this.context = context;
        this.names = names;
        this.roles = roles;
        this.images = images;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.player_item, null);
        TextView label = (TextView) row.findViewById(R.id.textView6);
        TextView label1 = (TextView) row.findViewById(R.id.textView3);
        ImageView icon = (ImageView) row.findViewById(R.id.imageView2);
        label.setText(names[position]);
        label1.setText(roles[position]);
        icon.setImageResource(images[position]);
        return (row);
    }
}