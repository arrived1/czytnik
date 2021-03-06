package com.czytnik.com;

import android.graphics.Bitmap;
import android.os.StrictMode;
import android.util.Log;
import android.util.Pair;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class RSSDomParser {
    private static String TAG_CHANNEL = "channel";
    private static String TAG_TITLE = "title";
    private static String TAG_DESRIPTION = "description";
    private static String TAG_PUB_DATE = "pubDate";
    private static String TAG_LINK = "link";
    private static String TAG_GENERATOR = "generator";
    private static String TAG_ITEM = "item";
    private static String TAG_GUID = "guid";
    private static String TAG_URL = "url";
    private static String TAG_ATOM_LINK = "atom:guid";

    private StringParser parser = new StringParser();
    private Downloader downloader = new Downloader();
    private TimeMeasurement timeMeasurement = new TimeMeasurement();

    public RSSDomParser() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public RSSFeed getRSSFeed(String url) {
        RSSFeed rssFeed = null;
        timeMeasurement.start();
        String rss_feed_xml = downloader.getWebsiteFromUrl(url);
        timeMeasurement.stopAndParse("DUPA, download: ");

        timeMeasurement.start();
        if (rss_feed_xml != null) { // check if RSS XML fetched or not
            try {
                // parse the xml
                Document doc = this.getDomElement(rss_feed_xml);
                NodeList nodeList = doc.getElementsByTagName(TAG_CHANNEL);
                Element e = (Element) nodeList.item(0);

                // RSS nodes
                String title = this.getValue(e, TAG_TITLE);
                String description = this.getValue(e, TAG_DESRIPTION);
                String pubdate = this.getValue(e, TAG_PUB_DATE);
                String link = this.getValue(e, TAG_LINK);
                String generator = this.getValue(e, TAG_GENERATOR);
                RSSImage image = getRSSImage(url);
                String atomlink = this.getValue(e, TAG_ATOM_LINK);
                List<RSSItemParcelable> rssItems = getRSSFeedItems(url);

                rssFeed = new RSSFeed(title, description, pubdate, link, generator,
                                      image, atomlink, rssItems);
                timeMeasurement.stopAndParse("DUPA, parsing: ");
            }
            catch (Exception e) {
                e.printStackTrace(); // Check log for errors
            }
        }
        else {
            // failed to fetch rss xml
        }
        return rssFeed;
    }

    private List<RSSItemParcelable> getRSSFeedItems(String rss_url){
        List<RSSItemParcelable> itemsList = new ArrayList<RSSItemParcelable>();
        String rss_feed_xml = downloader.getWebsiteFromUrl(rss_url);

        if(rss_feed_xml != null){ // check if RSS XML fetched or not
            try{ // parse the xml
                Document doc = this.getDomElement(rss_feed_xml);
                NodeList nodeList = doc.getElementsByTagName(TAG_CHANNEL);
                Element e = (Element) nodeList.item(0);
                NodeList items = e.getElementsByTagName(TAG_ITEM); // Getting items array


                for(int i = 0; i < 5; i++){ // looping through each item
//                for(int i = 0; i < items.getLength(); i++){ // looping through each item
                    Element e1 = (Element) items.item(i);

                    String title = this.getValue(e1, TAG_TITLE);
                    String link = this.getValue(e1, TAG_LINK);
                    String description = this.getValue(e1, TAG_DESRIPTION);
                    String pubdate = this.getValue(e1, TAG_PUB_DATE);
                    String guid = this.getValue(e1, TAG_GUID);

                    //additional parsing, date and description
                    pubdate = parser.parsePubDate(pubdate);

                    Pair<String, String> pair = parser.parseDescribtion(description);
                    String picUrl = pair.first;
                    description = pair.second;

//                    TimeMeasurement timeMeasurement1 = new TimeMeasurement();
//                    timeMeasurement1.start();
                    Bitmap bmpImg = downloader.downloadBitmap(picUrl);
//                    timeMeasurement1.stopAndParse("DUPA, bitmap download: ");

                    RSSItemParcelable rssItem = new RSSItemParcelable(title, link, description,
                                                                      guid, pubdate, guid, bmpImg);
                    itemsList.add(rssItem);
                }
            }catch(Exception e){
                e.printStackTrace(); // Check log for errors
            }
        }
        return itemsList;
    }

    private RSSImage getRSSImage(String rss_url){
        RSSImage image = null;
        String rss_feed_xml = downloader.getWebsiteFromUrl(rss_url);

        if(rss_feed_xml != null){ // check if RSS XML fetched or not
            try{ // parse the xml
                Document doc = this.getDomElement(rss_feed_xml);
                NodeList nodeList = doc.getElementsByTagName(TAG_CHANNEL);
                Element e = (Element) nodeList.item(0);

                String link = this.getValue(e, TAG_LINK);
                String title = this.getValue(e, TAG_TITLE);
                String url = this.getValue(e, TAG_URL);

                image = new RSSImage(link, title, url);

            }catch(Exception e){
                e.printStackTrace(); // Check log for errors
            }
        }
        return image;
    }

    private Document getDomElement(String xml) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = (Document) db.parse(is);

        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }

        return doc;
    }

    private final String getElementValue(Node elem) {
        Node child;
        if (elem != null) {
            if (elem.hasChildNodes()) {
                for (child = elem.getFirstChild(); child != null; child = child
                        .getNextSibling()) {
                    if (child.getNodeType() == Node.TEXT_NODE ||
                        (child.getNodeType() == Node.CDATA_SECTION_NODE)) {
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }

    private String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }
}
