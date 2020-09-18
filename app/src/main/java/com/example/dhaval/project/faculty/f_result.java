package com.example.dhaval.project.faculty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dhaval.project.R;
import com.example.dhaval.project.principal.p_res1;
import com.example.dhaval.project.principal.p_res2;
import com.example.dhaval.project.principal.p_res3;

public class f_result extends AppCompatActivity {

    WebView wv1;
    String url="http://result.gujaratuniversity.ac.in/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_result);
        wv1=(WebView)findViewById(R.id.result);
        wv1.setWebViewClient(new myc());
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(url);
    }
    public class myc extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
