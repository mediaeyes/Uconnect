package urekamedia.com.usdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import urekamedia.com.usdk.utils.Constants;

public class BannerActivity extends Activity {
    private Handler handler;
    private Runnable myRunnable;

    private static Context context;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        Intent intent = getIntent();
        showBanner(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG-BannerActivity", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG-BannerActivity", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG-BannerActivity", "onPause");
        destroyWebView();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG-BannerActivity", "onStop");
        destroyWebView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG-BannerActivity", "onDestroy");
        destroyWebView();
    }


    public void destroyWebView() {
        if (mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
    }

    public void showBanner(Intent intent){

    }

}
