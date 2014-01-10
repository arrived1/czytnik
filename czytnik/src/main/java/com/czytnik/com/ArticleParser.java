package com.czytnik.com;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SG0220055 on 1/10/14.
 */
public class ArticleParser {

    private void parseArticle(String url) {
        try {
            Log.e("DUPAAAAAAA --------------------------------------------------------->", "");
            Log.e("DUPAAAAAAA url", url);
            org.jsoup.nodes.Document doc;
            doc = Jsoup.connect(url).get(); // need http protocol

            String title = doc.title();  // get page title
//            Log.e("DUPAAAAAAA", "title : " + title);

            String additionalArticles = "Więcej";

            Elements paragraphs = doc.select("article").first().select("p");
            List<String> body = new ArrayList<String>();
            for (org.jsoup.nodes.Element p : paragraphs)
            {
                String paragraph = p.text();
                if(!paragraph.contains(additionalArticles)) {
                    body.add(p.text());
//                     Log.e("DUPAAAAAAA", paragraph + "\n");
                }
            }
//            Log.e("DUPAAAAAAA", "article : " + body);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
