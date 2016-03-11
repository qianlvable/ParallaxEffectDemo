package com.lvable.parallaxeffectdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener{

    public enum TYPE {YAHOO_TYPE,NORMAL_TYPE};
    private float mDistanceVal = 0.6f;
    private float mSpeedVal = 0.6f;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnYahoo = (Button)findViewById(R.id.btn_yahoo_effect);
        Button btnNormal = (Button)findViewById(R.id.btn_normal_effect);
        SeekBar speedSeekBar = (SeekBar)findViewById(R.id.speed_seekbar);
        SeekBar distanceSeekBar = (SeekBar)findViewById(R.id.distance_seekbar);

        btnYahoo.setOnClickListener(this);
        btnNormal.setOnClickListener(this);

        speedSeekBar.setOnSeekBarChangeListener(this);
        distanceSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putFloat(BundleKey.PARALLAX_SPEED, mSpeedVal);
        if (view.getId() == R.id.btn_yahoo_effect){
            Intent intent = new Intent(MainActivity.this, YahooParallaxActivity.class);
            intent.putExtra(BundleKey.TYPE_YAHOO, bundle);
            startActivity(intent);
        }else if (view.getId() == R.id.btn_normal_effect){
            Intent intent = new Intent(MainActivity.this, NormalParallaxActivity.class);
            bundle.putFloat(BundleKey.PARALLAX_DISTANCE, mDistanceVal);
            intent.putExtra(BundleKey.TYPE_NORMAL, bundle);
            startActivity(intent);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d(TAG,"seek val "+i);
        if (seekBar.getId() == R.id.distance_seekbar){
            mDistanceVal = 1-i/100f;
            Log.d(TAG,"distance " + mDistanceVal);
        }else{
            mSpeedVal = i/100f;
            Log.d(TAG,"speed "+mSpeedVal);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
