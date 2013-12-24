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
//        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//        fragment.setArguments(args);
        return fragment;

    }

    public PlaceholderFragment() {
//        fragmentLayoutId = R.layout.fragment_main;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
//        return rootView;
//    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        ((MainReaderActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
//    }
}
