package com.czytnik.com;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class ReaderFragment extends CustomeFragment {

    public ReaderFragment() {
        fragmentLayoutId = R.layout.fragment_reader;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RSSParser parser = new RSSParser();
        RSSFeed feed = parser.getRSSFeed("http://www.sportowefakty.pl/siatkowka/index.rss");








//        String txt = feed.getTitle() + " " + feed.getPubdate() + " size: " + feed.getRSSItems().size();
//        for(int i = 0; i < feed.getRSSItems().size(); ++i) {
//            RSSItem iteam = feed.getRSSItems().get(i);
//            txt += iteam.getTitle() + " " + iteam.getPubdate();
//        }
        View rootView = inflater.inflate(fragmentLayoutId, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(txt);
        return rootView;
    }


}
