package com.freeoda.franktirkey.smfes;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new StudyFragment();
            case 1:
                return new RoutineFragment();
            case 2:
                return new ChatFragment();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
