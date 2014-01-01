package com.czytnik.com;


import android.graphics.Bitmap;

abstract class RSSItem {
    protected String title;
    protected String link;
    protected String description;
    protected String article;
    protected String pubdate;
    protected String guid;
    protected Bitmap bmpImg;

    protected RSSItem() {}

    public RSSItem(String title, String link, String description, String article, String pubdate, String guid, Bitmap bmpImg) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.article = article;
        this.guid = guid;
        this.pubdate = pubdate;
        this.bmpImg = bmpImg;
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

    public String getArticle() {
        return article;
    }

    public String getPubdate() {
        return pubdate;
    }

    public String getGuid() {
        return guid;
    }

    public Bitmap getbmpImg() {
        return bmpImg;
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
//    public void setArticle(String article) {
//        this.article = article;
//    }
//
//    public void setPubdate(String pubdate) {
//        this.pubdate = pubdate;
//    }
//
//    public void setGuid(String guid) {
//        this.guid = guid;
//
//
//    public void setBmpImg(String bmpImg) {
//        this.bmpImg = bmpLink;
//    }

}
