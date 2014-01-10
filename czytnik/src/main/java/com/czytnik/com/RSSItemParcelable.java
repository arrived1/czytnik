package com.czytnik.com;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;



public class RSSItemParcelable extends RSSItem implements Parcelable {

    public RSSItemParcelable(String title, String link, String description,
                             String articleLink, String pubdate, String guid, Bitmap bmpImg) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.articleLink = articleLink;
        this.guid = guid;
        this.pubdate = pubdate;
        this.bmpImg = bmpImg;
    }

    public RSSItemParcelable(RSSItem item) {
        super(item.getTitle(), item.getLink(), item.getDescription(),
              item.getArticleLink(), item.getPubdate(), item.getGuid(),
              item.getbmpImg());
    }

    public RSSItemParcelable(Parcel in){
        String[] data = new String[6];

        in.readStringArray(data);
        this.title = data[0];
        this.link = data[1];
        this.description = data[2];
        this.articleLink= data[3];
        this.pubdate = data[4];
        this.guid = data[5];

        this.bmpImg = (Bitmap)in.readParcelable(Bitmap.class.getClassLoader());
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                this.title,
                this.link,
                this.description,
                this.articleLink,
                this.pubdate,
                this.guid});

        dest.writeParcelable(this.bmpImg, flags);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public RSSItemParcelable createFromParcel(Parcel in) {
            return new RSSItemParcelable(in);
        }

        public RSSItemParcelable[] newArray(int size) {
            return new RSSItemParcelable[size];
        }
    };
}
