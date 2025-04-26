package com.example.gamestop;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        setupExpandableSection(R.id.help_section_download, R.id.arrow_download, R.id.desc_download);
        setupExpandableSection(R.id.help_section_payment, R.id.arrow_payment1, R.id.desc_payment1);
        setupExpandableSection(R.id.help_section_crash, R.id.arrow_crash, R.id.desc_crash);
        setupExpandableSection(R.id.help_section_refund, R.id.arrow_refund, R.id.desc_refund);
        setupExpandableSection(R.id.help_section_account, R.id.arrow_account1, R.id.desc_account1);
        setupExpandableSection(R.id.help_section_dlc, R.id.arrow_dlc1, R.id.desc_dlc1);
        setupExpandableSection(R.id.help_section_multiplayer, R.id.arrow_multiplayer, R.id.desc_multiplayer);
        setupExpandableSection(R.id.help_section_preorder, R.id.arrow_preorder, R.id.desc_preorder);
        setupExpandableSection(R.id.help_section_launcher, R.id.arrow_launcher, R.id.desc_launcher);
        setupExpandableSection(R.id.help_section_update, R.id.arrow_update1, R.id.desc_update1);
        setupExpandableSection(R.id.help_section_contact, R.id.arrow_contact, R.id.desc_contact);
        setupExpandableSection(R.id.help_section_devices, R.id.arrow_devices, R.id.desc_devices);
        setupExpandableSection(R.id.help_section_install_error, R.id.arrow_install_error, R.id.desc_install_error);
        setupExpandableSection(R.id.help_section_keys, R.id.arrow_keys, R.id.desc_keys);
        setupExpandableSection(R.id.help_section_subscription, R.id.arrow_subscription1, R.id.desc_subscription1);

        findViewById(R.id.back3).setOnClickListener(v -> {
            home_page.openDrawerOnResume = true;
            new Handler().postDelayed(() -> {
                getOnBackPressedDispatcher().onBackPressed();
            }, 100);

        });


    }

    private void setupExpandableSection(int sectionId, int arrowId, int descId) {
        LinearLayout section = findViewById(sectionId);
        ImageView arrow = findViewById(arrowId);
        TextView desc = findViewById(descId);

        section.setOnClickListener(v -> {
            boolean isVisible = desc.getVisibility() == View.VISIBLE;
            desc.setVisibility(isVisible ? View.GONE : View.VISIBLE);
            arrow.animate().rotation(isVisible ? 0f : 180f).setDuration(200).start();
        });
    }
}
