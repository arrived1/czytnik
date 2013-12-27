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


        TimeMeasurement timeMeasurement = new TimeMeasurement();
        timeMeasurement.start();
        loadSites();
        timeMeasurement.stopAndParse("DUPA, download and parse: ");

    }

//    public List<RSSFeed> getFeeds() {
//        return feeds;
//    }

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
