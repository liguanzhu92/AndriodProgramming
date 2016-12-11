package com.example.guanzhuli.b6firstapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Guanzhu Li on 12/8/2016.
 */
public class LeftBarAdapter extends ArrayAdapter {
    Context context;
    int resource;
    String  infor[];
    public LeftBarAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LeftBarHolder holder= null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        }
        return row;
    }
    static class LeftBarHolder {
        ImageView mImageView;
        TextView mTextView;
    }
}
