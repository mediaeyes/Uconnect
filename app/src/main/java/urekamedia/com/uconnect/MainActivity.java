package urekamedia.com.uconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import urekamedia.com.usdk.UrekaSdk;
import urekamedia.com.usdk.interfaces.iBanner;
import urekamedia.com.usdk.interfaces.iDefaultBanner;
import urekamedia.com.usdk.interfaces.iLuckyDraw;
import urekamedia.com.usdk.interfaces.iVideo;
import urekamedia.com.usdk.model.adDefaultBanner;
import urekamedia.com.usdk.model.adInSong;
import urekamedia.com.usdk.model.adLuckyDraw;
import urekamedia.com.usdk.model.prerollVideo;

public class MainActivity extends AppCompatActivity{
    private static int times = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        times = times + 1;

//        String ktv_id = "66688";
//        String box_id = "px66688";

        String ktv_id = "7";
        String box_id = "109204";
        String song_id = "903840";
        boolean is_autoSong = false;

        //Insong banner
        UrekaSdk.getBanner(ktv_id, box_id, song_id, 4, this, new iBanner() {
            @Override
            public void onSuccess(adInSong result) {
                Log.d("TAG-onSuccess-position", "result: " + result.getPosition());
                Log.d("TAG-onSuccess-getBanner", "result: " + result.getBanner());
                Log.d("TAG-onSuccess-getWidth", "result: " + result.getWidth());
                Log.d("TAG-onSuccess-getHeight", "result: " + result.getHeight());
                // show banner sau bao nhiêu giây
                Log.d("TAG-onSuccess-getTime", "result: " + result.getTime());
                // show banner trong bao nhiêu giây
                Log.d("TAG-onSuccess-Time_show", "result: " + result.getTime_show());
            }

            @Override
            public void onError(Throwable t) {

            }
        });

        // luckydraw
        UrekaSdk.getLuckyDraw(ktv_id, box_id, song_id, is_autoSong, this, new iLuckyDraw() {
            @Override
            public void onSuccess(adLuckyDraw luckyDraw) {
                boolean status = luckyDraw.isStatus();
                if (status) {
                    int is_win = luckyDraw.getIs_win();
                    if (is_win == 1) {
                        // Banner trúng thưởng
                        Log.d("TAG-onSuccess", "is_win: " + luckyDraw.getBanner());
                        Log.d("TAG-onSuccess", "timeout: " + luckyDraw.getTimeout());
                    } else {
                        // Banner không trúng thưởng
                        Log.d("TAG-onSuccess", "is_not_win: " + luckyDraw.getBanner());
                        Log.d("TAG-onSuccess", "timeout: " + luckyDraw.getTimeout());
                    }
                } else {
                    // không trúng thưởng, không trả banner
                }
            }

            @Override
            public void onError(Throwable t) {

            }
        });

        //Default Screen
        UrekaSdk.getDefaultBanner(ktv_id, box_id, song_id, this, new iDefaultBanner() {
            @Override
            public void onSuccess(adDefaultBanner defaultBanner) {
                Log.d("TAG-onSuccess", "defaultBanner: " + defaultBanner.getBanner());
                Log.d("TAG-onSuccess", "defaultBanner: " + defaultBanner.getTimeout());
            }

            @Override
            public void onError(Exception e) {

            }
        });

        //Video full Screen
        UrekaSdk.getVideo(ktv_id, box_id, song_id, this, new iVideo() {
            @Override
            public void onSuccess(prerollVideo video) {
                Log.d("TAG-onSuccess-Video", "getTime_show: " + video.getTime_show());
                Log.d("TAG-onSuccess-Video", "getUrl: " + video.getUrl());
            }

            @Override
            public void onError(Exception e) {
                Log.d("TAG-onSuccess-Video", "Exception: " + e.getMessage());

            }
        });
    }
}