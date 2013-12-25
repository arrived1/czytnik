package com.czytnik.com;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

public class CustomArrayAdapter extends ArrayAdapter<RSSFeed> {
    private Context context;
    private List<RSSFeed> objects = new Vector<RSSFeed>();

    public CustomArrayAdapter(Context context, List<RSSFeed> objects) {
        super(context, R.layout.list_item, objects);

        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textView1 = (TextView)rowView.findViewById(R.id.text1);
        textView1.setText(objects.get(position).getTitle());

        TextView textView2 = (TextView)rowView.findViewById(R.id.text2);
        textView2.setText(objects.get(position).getDescription());

//        ImageView imageView = (ImageView)rowView.findViewById(R.id.flag);
//        imageView.setImageResource(R.drawable.ic);

        return rowView;
    }
}
