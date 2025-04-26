package com.example.gamestop;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FAQ extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_faq);

            setupExpandableSection(R.id.faq_section_refund1, R.id.arrow_refund1, R.id.desc_refund1);
            setupExpandableSection(R.id.faq_section_launch, R.id.arrow_launch, R.id.desc_launch);
            setupExpandableSection(R.id.faq_section_multiple, R.id.arrow_multiple, R.id.desc_multiple);
            setupExpandableSection(R.id.faq_section_preload, R.id.arrow_preload, R.id.desc_preload);
            setupExpandableSection(R.id.faq_section_account1, R.id.arrow_account1, R.id.desc_account1);
            setupExpandableSection(R.id.faq_section_update1, R.id.arrow_update1, R.id.desc_update1);
            setupExpandableSection(R.id.faq_section_dlc1, R.id.arrow_dlc1, R.id.desc_dlc1);
            setupExpandableSection(R.id.faq_section_controller, R.id.arrow_controller, R.id.desc_controller);
            setupExpandableSection(R.id.faq_section_subscription1, R.id.arrow_subscription1, R.id.desc_subscription1);
            setupExpandableSection(R.id.faq_section_error, R.id.arrow_error, R.id.desc_error);
            setupExpandableSection(R.id.faq_section_login, R.id.arrow_login, R.id.desc_login);
            setupExpandableSection(R.id.faq_section_payment1, R.id.arrow_payment1, R.id.desc_payment1);
            setupExpandableSection(R.id.faq_section_install, R.id.arrow_install, R.id.desc_install);
            setupExpandableSection(R.id.faq_section_friend, R.id.arrow_friend, R.id.desc_friend);

            findViewById(R.id.back1).setOnClickListener(v -> {
                home_page.openDrawerOnResume1 = true;
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