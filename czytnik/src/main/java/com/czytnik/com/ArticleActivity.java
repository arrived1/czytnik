package com.czytnik.com;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        Bundle data = getIntent().getExtras();
        RSSItemParcelable item = (RSSItemParcelable) data.getParcelable("ARTICLE");

        String txt = item.getDescription() + "\n\n" + item.getArticle();

        TextView textView1 = (TextView)findViewById(R.id.articleTxt);
        textView1.setText(txt);

        ImageView imageView = (ImageView)findViewById(R.id.articlePic);
        Bitmap pic = item.getbmpImg();
        int picSize = 250;
        pic = getResizedBitmap(pic, picSize, picSize);
        imageView.setImageBitmap(pic);

    }

    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix(); // CREATE A MATRIX FOR THE MANIPULATION
        matrix.postScale(scaleWidth, scaleHeight); // RESIZE THE BIT MAP

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }

}
