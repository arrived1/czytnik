package com.czytnik.com;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ArticleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Bundle data = getIntent().getExtras();
        RSSItemParcelable item = (RSSItemParcelable) data.getParcelable("ARTICLE");

        TextView textView1 = (TextView)findViewById(R.id.articleTxt);
        textView1.setText(item.getDescription());

    }

}
