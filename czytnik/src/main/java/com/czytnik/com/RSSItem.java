package com.czytnik.com;


import android.util.Pair;

public class RSSItem {
    protected String title;
    protected String link;
    protected String description;
    protected String pubdate;
    protected String guid;
    protected String picUrl;

    protected RSSItem() {}

    public RSSItem(String title, String link, String description, String pubdate, String guid) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.guid = guid;
        this.pubdate = pubdate;

//        String tmpDescription = description;

//        StringParser parser = new StringParser();
//        this.pubdate = parser.parsePubDate(pubdate);
//
////        if(picUrl.equals(null)) {
//            Pair<String, String> pair = parser.parseDescribtion(description);
//            this.picUrl = pair.first;
//            this.description = pair.second;
////        }
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getPubdate() {
        return pubdate;
    }

    public String getGuid() {
        return guid;
    }

    public String getPicUrl() {
        return picUrl;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setPubdate(String pubdate) {
//        this.pubdate = pubdate;
//    }
//
//    public void setGuid(String guid) {
//        this.guid = guid;
//    }
}
