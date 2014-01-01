package com.czytnik.com;


import android.util.Log;

public class TimeMeasurement {
    private long startTime = 0;
    private long stopTime = 0;
    private long duration = 0;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    public void stopAndSave() {
        stopTime = System.currentTimeMillis();
        duration += stopTime - startTime;
    }

    public void getSavedTime(String msg) {
        time(duration, msg);
    }

    public void stopAndParse(String msg) {
        stopTime = System.currentTimeMillis();

        time(stopTime - startTime, msg);
    }

    private void time(long interval, String msg) {
        int tens = (int) interval;
        int seconds = (int) interval / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        tens = tens % 10;
        seconds = seconds % 60;

        String time = String.format("%d:%02d:%02d.%d", hours, minutes, seconds, tens);
        Log.d(msg, time);
    }

}
