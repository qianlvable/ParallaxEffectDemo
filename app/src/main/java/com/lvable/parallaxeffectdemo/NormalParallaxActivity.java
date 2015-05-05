package com.lvable.parallaxeffectdemo;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;


public class NormalParallaxActivity extends ActionBarActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_parallax);


        // Hide status bar
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else {
            // Hide the status bar.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

        Bundle bundle = getIntent().getBundleExtra("normal");
        float speed = bundle.getFloat("speed");
        float distance = bundle.getFloat("distance");
        Log.d("wtf",speed+","+distance);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(), MainActivity.TYPE.NORMAL_TYPE);
        mPager.setAdapter(mPagerAdapter);
        int[] resId = {R.id.title_big,R.id.icon_img,R.id.small_title};
        mPager.setPageTransformer(true, new ParallaxTransformer(speed, distance, resId, false));
    }


}
