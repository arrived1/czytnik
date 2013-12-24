package com.czytnik.com;


import android.annotation.TargetApi;
import android.support.v4.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomeList extends ListFragment {

    String[] countries = new String[] {
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
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        /** Creating an array adapter to store the list of countries **/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,countries);

        /** Setting the list adapter for the ListFragment */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}