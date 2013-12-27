package com.czytnik.com;


import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

public class RSSItemParcelable extends RSSItem implements Parcelable {

    public RSSItemParcelable(RSSItem item) {
        super();
//        super(item.getTitle(), item.getLink(), item.getDescription(), item.getPubdate(), item.getGuid());

        this.title = item.getTitle();
        this.link = item.getLink();
        this.guid = item.getGuid();

        StringParser parser = new StringParser();
        this.pubdate = parser.parsePubDate(item.getPubdate());

        Pair<String, String> pair = parser.parseDescribtion(item.getDescription());
        this.picUrl = pair.first;
        this.description = pair.second;
    }

    public RSSItemParcelable(Parcel in){
        String[] data = new String[6];

        in.readStringArray(data);
        this.title = data[0];
        this.link = data[1];
        this.description = data[2];
        this.pubdate = data[3];
        this.guid = data[4];
        this.picUrl = data[5];
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
                this.pubdate,
                this.guid,
                this.picUrl});
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
