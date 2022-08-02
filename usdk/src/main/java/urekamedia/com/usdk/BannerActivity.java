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
        String url = Constants.BANNER_URL +
                "?time_show=" +intent.getIntExtra("time_show", 1)+
                "&deviceid=" +intent.getStringExtra("device")+
                "&position=" +intent.getIntExtra("position_type", 0)+
                "&width=" +intent.getIntExtra("width", 0)+
                "&height=" +intent.getIntExtra("height", 0)+
                "&ktvads=" +intent.getIntExtra("type_ads", 0)+
                "&ktv_id="+ 39879;

        setContentView(R.layout.activity_banner);
        mWebView = findViewById(R.id.webView);
        defaultSetting();
        mWebView.loadUrl(url);

        closeAfter(intent.getIntExtra("time_show", 1));

    }

    public void closeAfter(int finishTime){
        handler =  new Handler();
        myRunnable = new Runnable() {
            public void run() {
                finish();
            }
        };
        handler.postDelayed(myRunnable, finishTime * 1000);
    }

    private void defaultSetting() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        mWebView.clearHistory();
        mWebView.clearCache(true);
        mWebView.setBackgroundColor(Color.TRANSPARENT);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

        });
    }


}
