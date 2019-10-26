package com.freeoda.franktirkey.smfes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem tabStudy,tabRoutine,tabChat;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(" "+getResources().getString(R.string.app_name));
        tabLayout = findViewById(R.id.tablayout);
        tabStudy = findViewById(R.id.tabStudy);
        tabRoutine = findViewById(R.id.tabRoutine);
        tabChat = findViewById(R.id.tabChat);
        viewPager = findViewById(R.id.viewPager);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //////////////////////////////////////


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());

                if (tab.getPosition() == 0) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this,
                            R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(HomeActivity.this,
                            R.color.colorAccent));
                    getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this,
                            R.color.colorAccentDark));
                    //toolbar.setLogo(R.drawable.chat_icon);
                } else if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this,
                            android.R.color.darker_gray));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(HomeActivity.this,
                            android.R.color.darker_gray));
                    getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this,
                            android.R.color.darker_gray));
                   // toolbar.setLogo(R.drawable.status_icon);
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this,
                            R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(HomeActivity.this,
                            R.color.colorPrimary));
                    getWindow().setStatusBarColor(ContextCompat.getColor(HomeActivity.this,
                            R.color.colorPrimaryDark));
                    //toolbar.setLogo(R.drawable.call_icon);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
