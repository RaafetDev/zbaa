package com.zero.zerobls.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zero.zerobls.R;

public class MainFragment extends Fragment {

    private WebView webView;
    private ImageButton homeButton;
    private ImageButton accountsButton;
    private ImageButton centerButton;
    private ImageButton botConfigButton;
    private ImageButton profileButton;

    private static final String HOME_URL = "https://example.com"; // Change to your URL

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initViews(view);
        setupWebView();
        setupButtons();

        return view;
    }

    private void initViews(View view) {
        webView = view.findViewById(R.id.webview);
        homeButton = view.findViewById(R.id.btn_home);
        accountsButton = view.findViewById(R.id.btn_accounts);
        centerButton = view.findViewById(R.id.btn_center);
        botConfigButton = view.findViewById(R.id.btn_bot_config);
        profileButton = view.findViewById(R.id.btn_profile);
    }

    private void setupWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(HOME_URL);
    }

    private void setupButtons() {
        homeButton.setOnClickListener(v -> loadUrl(HOME_URL));

        accountsButton.setOnClickListener(v -> {
            // Load accounts page URL or local HTML file
            loadUrl("https://example.com/accounts");
        });

        centerButton.setOnClickListener(v -> {
            // Center button action - implement your logic
        });

        botConfigButton.setOnClickListener(v -> {
            // Bot config button action - implement your logic
        });

        profileButton.setOnClickListener(v -> {
            // Profile button action - implement your logic
        });
    }

    private void loadUrl(String url) {
        webView.loadUrl(url);
    }

    public void loadLocalFile(String fileName) {
        webView.loadUrl("file:///android_asset/" + fileName);
    }
}