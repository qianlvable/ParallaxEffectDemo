package com.lvable.parallaxeffectdemo;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener{

    public static enum TYPE {YAHOO_TYPE,NORMAL_TYPE};
    private float mDistanceVal = 0.6f;
    private float mSpeedVal = 0.6f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        SeekBar speedSeekBar = (SeekBar)findViewById(R.id.speed_seekbar);
        SeekBar distanceSeekBar = (SeekBar)findViewById(R.id.distance_seekbar);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        speedSeekBar.setOnSeekBarChangeListener(this);
        distanceSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn1){
            Intent intent = new Intent(MainActivity.this,YahooParallaxActivity.class);
            Bundle bundle = new Bundle();
            bundle.putFloat("speed",mSpeedVal);
            intent.putExtra("yahoo", bundle);
            startActivity(intent);
        }else if (view.getId() == R.id.btn2){
            Intent intent = new Intent(MainActivity.this,NormalParallaxActivity.class);
            Bundle bundle = new Bundle();
            bundle.putFloat("speed",mSpeedVal);
            bundle.putFloat("distance",mDistanceVal);
            intent.putExtra("normal",bundle);
            startActivity(intent);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d("wtf","seek val "+i);
        if (seekBar.getId() == R.id.distance_seekbar){

            mDistanceVal = 1-i/100f;
            Log.d("wtf","distance " + mDistanceVal);
        }else{
            mSpeedVal = i/100f;
            Log.d("wtf","speed "+mSpeedVal);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
