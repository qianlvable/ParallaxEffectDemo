package com.lvable.parallaxeffectdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Jiaqi Ning on 4/5/2015.
 */
public class SlidePagerAdapter extends FragmentStatePagerAdapter {
    MainActivity.TYPE mPageType;
    private static final int TOTAL_PAGE_COUNT = 3;

    public SlidePagerAdapter(FragmentManager fm, MainActivity.TYPE type) {
        super(fm);
        mPageType = type;
    }


    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.PAGE_INDEX, i);
        if (mPageType == MainActivity.TYPE.YAHOO_TYPE){
            Fragment fragment = new YahooSlidePageFragment();
            fragment.setArguments(bundle);
            return fragment;
        }else {
            Fragment fragment = new NormalSlidePageFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

    }

    @Override
    public int getCount() {
        return TOTAL_PAGE_COUNT;
    }
}
