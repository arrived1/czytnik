package com.czytnik.com;

public class RSSImage {
    private String link;
    private String title;
    private String URL;

    public RSSImage(String link, String title, String URL) {
        this.link = link;
        this.title = title;
        this.URL = URL;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getURL() {
        return URL;
    }

//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setURL(String URL) {
//        this.URL = URL;
//    }
}
