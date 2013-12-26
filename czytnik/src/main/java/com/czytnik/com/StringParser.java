package com.czytnik.com;


import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class StringParser {
    private Map<String, String> months = new HashMap<String, String>();
    private Map<String, String> days = new HashMap<String, String>();

    public StringParser() {
        months.put("Jan",  "Sty");
        months.put("Feb",  "Lut");
        months.put("Mar",  "Mar");
        months.put("Apr",  "Kwi");
        months.put("May",  "Maj");
        months.put("Jun",  "Cze");
        months.put("Jul",  "Li");
        months.put("Aug",  "Sie");
        months.put("Sept", "Wrz");
        months.put("Oct",  "Paź");
        months.put("Nov",  "Lis");
        months.put("Dec",  "Gru");

        days.put("Mon", "Pn");
        days.put("Tue", "Wt");
        days.put("Wed", "Śr");
        days.put("Thu", "Czw");
        days.put("Fri", "Pt");
        days.put("Sat", "Sob");
        days.put("Sun", "Niedz");
    }


    public String parsePubDate(String date) {
        String newDate = date.substring(0, date.length() - 9); //":78 +1000" - 9 signs

        newDate = replaceString(months, newDate);
        newDate = replaceString(days, newDate);

        return newDate;
    }

    private String replaceString(Map<String, String> map, String date) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if(date.contains(key)) {
                date = date.replace(key, value);
            }
        }
        return date;
    }

}
