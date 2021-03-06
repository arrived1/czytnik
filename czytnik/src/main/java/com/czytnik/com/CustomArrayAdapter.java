package com.czytnik.com;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

public class CustomArrayAdapter extends ArrayAdapter<RSSItemParcelable> {
    private Context context;
    private List<RSSItemParcelable> rssItems = new Vector<RSSItemParcelable>();

    public CustomArrayAdapter(Context context, List<RSSItemParcelable> rssItems) {
        super(context, R.layout.list_item, rssItems);

        this.context = context;
        this.rssItems = rssItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textView1 = (TextView)rowView.findViewById(R.id.text1);
        textView1.setText(rssItems.get(position).getTitle());

        TextView textView2 = (TextView)rowView.findViewById(R.id.text2);
        textView2.setText(rssItems.get(position).getPubdate());

        ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
        imageView.setImageBitmap(rssItems.get(position).getbmpImg());

        return rowView;
    }
}
