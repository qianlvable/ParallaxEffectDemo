package com.lvable.parallaxeffectdemo;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


public class NormalParallaxActivity extends ActionBarActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_parallax);

        Bundle bundle = getIntent().getBundleExtra(BundleKey.TYPE_NORMAL);
        float speed = bundle.getFloat(BundleKey.PARALLAX_SPEED);
        float distance = bundle.getFloat(BundleKey.PARALLAX_DISTANCE);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager()
                , MainActivity.TYPE.NORMAL_TYPE);
        mPager.setAdapter(mPagerAdapter);
        int[] resId = {R.id.title_big,R.id.iv_icon,R.id.small_title};
        mPager.setPageTransformer(true, new ParallaxTransformer(speed, distance, resId, false));
    }


}
