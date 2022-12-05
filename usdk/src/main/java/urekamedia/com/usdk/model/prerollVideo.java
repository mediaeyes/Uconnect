package urekamedia.com.usdk.model;

public class prerollVideo {
    private int time_show;
    private String url;

    public prerollVideo() {

    }

    public int getTime_show() {
        return time_show;
    }

    public void setTime_show(int time_show) {
        this.time_show = time_show;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public prerollVideo(int time_show, String url) {
        this.time_show = time_show;
        this.url = url;
    }
}
