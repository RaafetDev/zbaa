package com.zero.zerobls.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zero.zerobls.R;

public class ActivationFragment extends Fragment {

    private Button activateButton;
    private static final String TELEGRAM_CONTACT = "https://t.me/your_username"; // Change this to your telegram

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activation, container, false);

        activateButton = view.findViewById(R.id.activate_button);

        activateButton.setOnClickListener(v -> openTelegram());

        return view;
    }

    private void openTelegram() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(TELEGRAM_CONTACT));
        startActivity(intent);
    }
}