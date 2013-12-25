package com.czytnik.com;

import 	android.support.v4.app.ListFragment;
import android.os.Bundle;

//A placeholder fragment containing a simple view.
public class PlaceholderFragment extends ListFragment {

    public static CustomList newInstance(int sectionNumber) {
        RSSParser parser = new RSSParser();

        RSSFeed feed = parser.getRSSFeed("http://www.sportowefakty.pl/pilka-reczna/index.rss");
        CustomList fragment;
        if(sectionNumber == 1) {
            fragment = new CustomList(feed);
        }
        else if(sectionNumber == 2) {
            fragment = new CustomList();
        }
        else {
            fragment = new CustomList();
        }

        Bundle args = new Bundle();
//        args.putInt("name", sectionNumber);
        fragment.setArguments(args);
        return fragment;

    }
}
