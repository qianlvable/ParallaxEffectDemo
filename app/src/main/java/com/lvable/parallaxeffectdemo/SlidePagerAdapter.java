package com.lvable.parallaxeffectdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Jiaqi Ning on 4/5/2015.
 */
public class SlidePagerAdapter extends FragmentStatePagerAdapter {
    MainActivity.TYPE mTYPE;
    private static final int NUM_PAGES = 3;

    public SlidePagerAdapter(FragmentManager fm,MainActivity.TYPE type) {
        super(fm);
        mTYPE = type;
    }


    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("index",i);
        if (mTYPE == MainActivity.TYPE.YAHOO_TYPE){
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
        return NUM_PAGES;
    }
}
