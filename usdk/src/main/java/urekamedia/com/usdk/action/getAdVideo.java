package urekamedia.com.usdk.action;

import android.util.Log;

import org.jetbrains.annotations.Nullable;

import urekamedia.com.usdk.interfaces.iVideo;
import urekamedia.com.usdk.model.adDefaultBanner;
import urekamedia.com.usdk.model.prerollVideo;
import urekamedia.com.usdk.utils.Constants;

public class getAdVideo {

    public static void callAdVideo(String ktv_id, String deviceid, String song_id, @Nullable final iVideo callback){
        try {
            int time_show = 6;
            String url = Constants.API_CONFIG + Constants.API_ROUTE_AD_VIDEO + "?ktv_id="+ktv_id+"&deviceid="+deviceid+"&song_id="+song_id;
            prerollVideo video = new prerollVideo();
            video.setTime_show(time_show);
            video.setUrl(url);
            callback.onSuccess(video);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
