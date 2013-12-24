package com.czytnik.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent gameIntent = new Intent(this, MainReaderActivity.class);
        startActivity(gameIntent);
        finish();
    }

}
