package com.czytnik.com;

import 	android.support.v4.app.ListFragment;
import android.os.Bundle;

public class PlaceholderFragment extends ListFragment {

    public static CustomList newInstance(RSSFeedManager feedMgr, int sectionNumber) {

        CustomList fragment;
        if(sectionNumber == 0) {
            fragment = new CustomList(feedMgr.getFeed(0));
        }
        else if(sectionNumber == 1) {
            fragment = new CustomList(feedMgr.getFeed(1));
        }
        else {
            fragment = new CustomList(feedMgr.getFeed(2));
        }

        Bundle args = new Bundle();
        args.putInt("name", sectionNumber);
        fragment.setArguments(args);

        return fragment;
    }
}
