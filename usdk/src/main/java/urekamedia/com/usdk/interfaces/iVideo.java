package urekamedia.com.usdk.interfaces;
import urekamedia.com.usdk.model.prerollVideo;

public interface iVideo {
    void onSuccess(prerollVideo video);
    void onError(Exception e);
}
