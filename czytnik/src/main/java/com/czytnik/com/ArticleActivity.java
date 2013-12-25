package com.czytnik.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by SG0220055 on 12/25/13.
 */
public class ArticleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        TextView textView1 = (TextView)findViewById(R.id.articleTxt);
        textView1.setText("Dziala");

    }

}
