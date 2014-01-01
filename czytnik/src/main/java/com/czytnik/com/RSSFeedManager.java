package com.czytnik.com;

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
        timeMeasurement.stopAndParse("------------------>DUPA, total download and parse: ");

    }

    public RSSFeed getFeed(int pos) {
        return feeds.get(pos);
    }

    private void loadSites() {
        RSSDomParser parser = new RSSDomParser();
        TimeMeasurement timeMeasurement1 = new TimeMeasurement();
        for(int i = 0; i < sites.size(); ++i) {
            timeMeasurement1.start();
            RSSFeed feed = parser.getRSSFeed(sites.get(i));
            feeds.add(feed);
            timeMeasurement1.stopAndParse("------------>DUPA, single download and parse: ");
        }
    }
}
