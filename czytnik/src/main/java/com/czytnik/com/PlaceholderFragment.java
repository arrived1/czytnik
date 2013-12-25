package com.czytnik.com;

import 	android.support.v4.app.ListFragment;
import android.os.Bundle;

//A placeholder fragment containing a simple view.
public class PlaceholderFragment extends ListFragment {

    public static CustomeList newInstance(int sectionNumber) {

        CustomeList fragment;
        if(sectionNumber == 1) {
            fragment = new CustomeList();
        }
        else if(sectionNumber == 2) {
            fragment = new CustomeList();
        }
        else {
            fragment = new CustomeList();
        }

        Bundle args = new Bundle();
//        args.putInt("name", sectionNumber);
        fragment.setArguments(args);
        return fragment;

    }
}
