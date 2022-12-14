package urekamedia.com.usdk.interfaces;
import urekamedia.com.usdk.model.adVideo;

public interface iVideo {
    void onSuccess(adVideo video);
    void onError(Throwable t);
}
