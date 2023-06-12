package com.example.myapplication222;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        // Finding the EditText and Button by their ids
        EditText urlEditText = findViewById(R.id.url_edit_text);
        Button goButton = findViewById(R.id.go_button);

        // Setting onClickListener on the Button to load URL in WebView
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(urlEditText.getText().toString());
                // Setting onClickListener on the Button to load URL in WebView
                goButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        webView.loadUrl(urlEditText.getText().toString());
                        WebViewClient webViewClient = new WebViewClient() {
                            @SuppressWarnings("deprecation") @Override
                            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                view.loadUrl(url);
                                return true;
                            }

                            @TargetApi(Build.VERSION_CODES.N) @Override
                            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                                view.loadUrl(request.getUrl().toString());
                                return true;
                            }

                        };
                        webView.setWebViewClient(webViewClient);
                    }
                });
            }
        });
    }
}