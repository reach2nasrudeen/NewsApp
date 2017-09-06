package com.example.app.News;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.base.BaseActivity;

/**
 * Created by nasrudeen on 6/9/17.
 */

public class NewsMoreActivity extends BaseActivity {
    private WebView mWebview;
    private String url;
//    private ProgressDialog progDailog;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_more);
        if (getIntent().hasExtra("url")) {
            url = getIntent().getStringExtra("url");
        }
//        progDailog = ProgressDialog.show(this, "Loading", "Please wait...", true);
//        progDailog.setCancelable(false);
        mWebview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setUseWideViewPort(true);
        mWebview.setWebViewClient(new WebViewClient() {

            /*@Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!progDailog.isShowing()) {
                    progDailog.show();
                }
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, final String url) {
                if (progDailog.isShowing()) {
                    progDailog.dismiss();
                }
            }*/
        });

        mWebview.loadUrl(url);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.mWebview.canGoBack()) {
            this.mWebview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
