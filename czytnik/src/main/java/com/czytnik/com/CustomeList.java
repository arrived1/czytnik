package com.czytnik.com;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.Arrays;
import java.util.List;

public class CustomeList extends ListFragment {

    List<String> countries = Arrays.asList(
//            String[] countries = new String[] {
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

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),
        CustomeArrayAdapter adapter = new CustomeArrayAdapter(inflater.getContext(),
//                                                                R.layout.list_item,
                                                                countries);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}