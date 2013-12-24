package com.czytnik.com;

import java.util.List;

public class RSSFeed {
    private String title;
    private String description;
    private String pubdate;
    private String link;
    private String generator;
    private RSSImage rssImage;
    private String atomlink;
    private List<RSSItem> rssItems;

    public RSSFeed() {}

    public RSSFeed(String title,
                   String description,
                   String pubdate,
                   String link,
                   String generator,
                   RSSImage rssImage,
                   String atomlink,
                   List<RSSItem> rssItems) {
        this.title = title;
        this.description = description;
        this.pubdate = pubdate;
        this.link = link;
        this.generator = generator;
        this.rssImage = rssImage;
        this.atomlink = atomlink;
        this.rssItems = rssItems;
    }

    public List<RSSItem> getRSSItems() {
        return rssItems;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubdate() {
        return pubdate;
    }

    public String getLink() {
        return link;
    }

    public String getGenerator() {
        return generator;
    }

    public RSSImage getRSSImage() {
        return rssImage;
    }

    public String getAtomlink() {
        return atomlink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public void setRSSImage(RSSImage RSSImage) {
        this.rssImage = RSSImage;
    }

    public void setAtomlink(String atomlink) {
        this.atomlink = atomlink;
    }

    public void setRSSItems(List<RSSItem> RSSItems) {
        this.rssItems = RSSItems;
    }
}
