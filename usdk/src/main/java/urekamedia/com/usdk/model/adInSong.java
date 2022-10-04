package urekamedia.com.usdk.model;

public class adInSong {
    private String position;
    private String banner;
    private int width;
    private int height;

    public adInSong() {

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public adInSong(String position, String banner, int width, int height) {
        this.position = position;
        this.banner = banner;
        this.width = width;
        this.height = height;
    }
}
