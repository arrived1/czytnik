package com.czytnik.com;


import android.util.Log;

import java.util.List;
import java.util.Vector;

public class RSSFeedManager {
    private List<String> sites = new Vector<String>();
    private List<RSSFeed> feeds = new Vector<RSSFeed>();

    public RSSFeedManager() {
        sites.add("http://www.sportowefakty.pl/siatkowka/index.rss");
        sites.add("http://www.sportowefakty.pl/koszykowka/index.rss");
        sites.add("http://www.sportowefakty.pl/moto/index.rss");


        long starTime = System.currentTimeMillis();
        loadSites();

        long endTime = System.currentTimeMillis() - starTime;
        time(endTime);

    }

    private void time(long interval) {
        int tens = (int) interval;
        int seconds = (int) interval / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        tens = tens % 10;
        seconds = seconds % 60;

        String time = String.format("%d:%02d:%02d.%d", hours, minutes, seconds, tens);
        Log.d("DUPA", time);
    }

    public List<RSSFeed> getFeeds() {
        return feeds;
    }

    public RSSFeed getFeed(int pos) {
        return feeds.get(pos);
    }

    private void loadSites() {
        RSSParser parser = new RSSParser();
        for(int i = 0; i < sites.size(); ++i) {
            RSSFeed feed = parser.getRSSFeed(sites.get(i));
            feeds.add(feed);
        }
    }
}
