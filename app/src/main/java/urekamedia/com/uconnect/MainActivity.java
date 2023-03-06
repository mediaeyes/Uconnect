package urekamedia.com.uconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import urekamedia.com.usdk.UrekaSdk;
import urekamedia.com.usdk.interfaces.iBanner;
import urekamedia.com.usdk.interfaces.iDefaultBanner;
import urekamedia.com.usdk.interfaces.iVideo;
import urekamedia.com.usdk.model.adDefaultScreen;
import urekamedia.com.usdk.model.adInSong;
import urekamedia.com.usdk.model.adVideo;
import urekamedia.com.usdk.model.adVideoPreroll;

public class MainActivity extends AppCompatActivity{
    private static int times = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        times = times + 1;

        String ktv_id = "001";
        String box_id = "001";
        String song_id = "903840";

        //Default Screen
        UrekaSdk.getDefaultBanner(ktv_id, box_id, 3, this, new iDefaultBanner() {
            @Override
            public void onSuccess(adDefaultScreen defaultBanner) {
                String type = defaultBanner.getType_ads();
                if(type.equals("banner")){
                    Log.d("TAG-DefaultBanner", "Banner: " + defaultBanner.getBanner_url());
                    Log.d("TAG-DefaultBanner", "Time Show: " + defaultBanner.getTime_show());
                }else if(type.equals("video")){
                    Log.d("TAG-DefaultBanner", "Video: " + defaultBanner.getBanner_url());
                    Log.d("TAG-DefaultBanner", "Time Show: " + defaultBanner.getTime_show());
                }else{
                    // chạy video của ktv
                    Log.d("TAG-DefaultBanner", "KTV VIDEO");
                }
            }

            @Override
            public void onError(Throwable t) {

            }
        });

        //Preroll Video
        UrekaSdk.getPrerollVideo(ktv_id, box_id, this, new iVideo() {
            @Override
            public void onSuccess(adVideoPreroll videoPreroll) {
                Log.d("TAG-Preroll", "Video Player: " + videoPreroll.getVast_xml());
                Log.d("TAG-Preroll", "Time Show Webview: " + videoPreroll.getTime_show());
                Log.d("TAG-Preroll", "Isset Ad: " + videoPreroll.getIssetItem());
            }

            @Override
            public void onError(Throwable t) {

            }
        });

        //Insong Banner
        UrekaSdk.getInsong(ktv_id, box_id, 2, song_id, this, new iBanner() {
            @Override
            public void onSuccess(adInSong inSong) {
                String type = inSong.getType_ads();
                if(type.equals("banner")){
                    Log.d("TAG-InSong", "Width: " + inSong.getWidth());
                    Log.d("TAG-InSong", "Height: " + inSong.getHeight());
                    Log.d("TAG-InSong", "Time Show: " + inSong.getTime());
                    Log.d("TAG-InSong", "Show in: " + inSong.getTime_show());
                    Log.d("TAG-InSong", "Position: " + inSong.getPosition());
                    Log.d("TAG-InSong", "Banner: " + inSong.getBanner_url());
                }else if(type.equals("video")){
                    Log.d("TAG-InSong", "Width: " + inSong.getWidth());
                    Log.d("TAG-InSong", "Height: " + inSong.getHeight());
                    Log.d("TAG-InSong", "Time Show: " + inSong.getTime());
                    Log.d("TAG-InSong", "Show in: " + inSong.getTime_show());
                    Log.d("TAG-InSong", "Position: " + inSong.getPosition());
                    Log.d("TAG-InSong", "Video: " + inSong.getBanner_url());
                }
            }

            @Override
            public void onError(Throwable t) {

            }
        });

    }
}