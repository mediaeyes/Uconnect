package urekamedia.com.usdk.model;

public class adVideo {
    private String time_show;
    private String type_ads;
    private String vast_xml;
    private String banner_url;

    public adVideo(String time_show, String type_ads, String vast_xml, String banner_url) {
        this.time_show = time_show;
        this.type_ads = type_ads;
        this.vast_xml = vast_xml;
        this.banner_url = banner_url;
    }

    public adVideo() {

    }

    public String getTime_show() {
        return time_show;
    }

    public void setTime_show(String time_show) {
        this.time_show = time_show;
    }

    public String getType_ads() {
        return type_ads;
    }

    public void setType_ads(String type_ads) {
        this.type_ads = type_ads;
    }

    public String getVast_xml() {
        return vast_xml;
    }

    public void setVast_xml(String vast_xml) {
        this.vast_xml = vast_xml;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }
}
