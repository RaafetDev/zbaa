package com.zero.zerobls.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zero.zerobls.R;

public class LoadingFragment extends Fragment {

    private TextView loadingText;
    private TextView versionText;
    private Handler handler;
    private int currentStep = 0;
    private String[] loadingMessages = {
            "Loading...",
            "Checking permissions...",
            "Connecting to server...",
            "Checking for updates..."
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loading, container, false);

        loadingText = view.findViewById(R.id.loading_text);
        versionText = view.findViewById(R.id.version_text);

        versionText.setText("v1.0.1");

        handler = new Handler(Looper.getMainLooper());
        startLoadingSequence();

        return view;
    }

    private void startLoadingSequence() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentStep < loadingMessages.length) {
                    loadingText.setText(loadingMessages[currentStep]);
                    currentStep++;
                    handler.postDelayed(this, 1500);
                } else {
                    // Loading complete, notify MainActivity to switch fragment
                    if (getActivity() instanceof LoadingCompleteListener) {
                        ((LoadingCompleteListener) getActivity()).onLoadingComplete();
                    }
                }
            }
        }, 500);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public interface LoadingCompleteListener {
        void onLoadingComplete();
    }
}