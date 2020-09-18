package com.example.dhaval.project.faculty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dhaval.project.R;

public class f_examschedule extends AppCompatActivity {

    WebView wv1;
    String url="https://www.gujaratuniversity.ac.in/custom/student/examination-schedule";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_examschedule);
        wv1=(WebView)findViewById(R.id.schdule);
        wv1.setWebViewClient(new mybro());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(url);
    }
    private class mybro extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
