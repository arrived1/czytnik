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
import java.util.Vector;

public class CustomList extends ListFragment {
    private Vector<RSSFeed> feeds = new Vector<RSSFeed>();

    public CustomList(RSSFeed feed) {
        this.feeds.add(feed);
    }

    public CustomList() {
        this.feeds = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CustomArrayAdapter adapter = new CustomArrayAdapter(inflater.getContext(), feeds);
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