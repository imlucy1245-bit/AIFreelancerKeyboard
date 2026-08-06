package com.aifreelancer.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AIKeyboardService extends InputMethodService {

    @Override
    public View onCreateInputView() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(0xFF222222);

        // AI Assistant & Macro Bar
        LinearLayout aiBar = new LinearLayout(this);
        aiBar.setOrientation(LinearLayout.HORIZONTAL);
        aiBar.setPadding(12, 12, 12, 12);

        Button btnTranslate = new Button(this);
        btnTranslate.setText("Translate");
        btnTranslate.setOnClickListener(v -> {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.commitText("[AI Translated] ", 1);
            }
        });

        Button btnProposal = new Button(this);
        btnProposal.setText("Proposal Draft");
        btnProposal.setOnClickListener(v -> {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.commitText("Hello, I am available for this project and can deliver on time. ", 1);
            }
        });

        aiBar.addView(btnTranslate);
        aiBar.addView(btnProposal);
        layout.addView(aiBar);

        // Branding Title
        TextView tvTitle = new TextView(this);
        tvTitle.setText("  — AIFreelancerKeyboard Active —");
        tvTitle.setTextColor(0xFF00FFCC);
        layout.addView(tvTitle);

        return layout;
    }
}
