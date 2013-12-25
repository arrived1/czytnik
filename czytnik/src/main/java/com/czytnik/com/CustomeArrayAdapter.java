package com.czytnik.com;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomeArrayAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> objects;

    public CustomeArrayAdapter(Context context, List<String> objects) {
        super(context, R.layout.list_item, objects);

        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textView1 = (TextView)rowView.findViewById(R.id.text1);
        textView1.setText(objects.get(position));

        TextView textView2 = (TextView)rowView.findViewById(R.id.text2);
        textView2.setText(objects.get(position) + " dupa");


//        ImageView imageView = (ImageView)rowView.findViewById(R.id.flag);
//        imageView.setImageResource(R.drawable.ic);

        return rowView;
    }
}
