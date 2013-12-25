package com.czytnik.com;

import 	android.support.v4.app.ListFragment;
import android.os.Bundle;

public class PlaceholderFragment extends ListFragment {

    public static CustomList newInstance(RSSFeedManager feedMgr, int sectionNumber) {

        CustomList fragment;
        if(sectionNumber == 1) {
            fragment = new CustomList(feedMgr.getFeed(1));
        }
        else if(sectionNumber == 2) {
            fragment = new CustomList(feedMgr.getFeed(2));
        }
        else {
            fragment = new CustomList(feedMgr.getFeed(3));
        }

        Bundle args = new Bundle();
        args.putInt("name", sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }
}
