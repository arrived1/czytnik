package com.czytnik.com;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class CustomList extends ListFragment {
    private RSSFeed feed;

    public CustomList(RSSFeed feed) {
        this.feed = feed;
    }

    public CustomList() {
        this.feed = null;
    }

    List<String> countries = Arrays.asList(
            "India",
            "Pakistan",
            "Sri Lanka",
            "China",
            "Bangladesh",
            "Nepal",
            "Afghanistan",
            "North Korea",
            "South Korea",
            "Japan"
    );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        CustomArrayAdapter adapter = new CustomArrayAdapter(inflater.getContext(), countries);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent gameIntent = new Intent(l.getContext(), ArticleActivity.class);
        startActivity(gameIntent);
    }
}