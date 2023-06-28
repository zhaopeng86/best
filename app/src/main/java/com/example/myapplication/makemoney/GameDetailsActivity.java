package com.example.myapplication.makemoney;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.example.myapplication.BaseActivity;
import com.example.myapplication.R;

public class GameDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        String url=getIntent().getStringExtra("url");
        initWebView(url);
    }


    public void  initWebView(String url){
        WebView webView=findViewById(R.id.webcontent);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//启用js
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);//解决视频无法播放问题
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
        webSettings.setDatabaseEnabled(true); // 开启 DB storage API 功能
//        webView.loadUrl("https://h.4399.com/play/201529.htm");//覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });
    }


}
