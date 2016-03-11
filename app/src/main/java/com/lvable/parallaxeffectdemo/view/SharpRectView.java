package com.lvable.parallaxeffectdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.lvable.parallaxeffectdemo.R;

/**
 * Created by Jiaqi Ning on 28/4/2015.
 */
public class SharpRectView extends View {
    private Paint mPaint;
    private Path mPath;
    public SharpRectView(Context context) {
        super(context);
        init();
    }

    public SharpRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SharpRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(getResources().getColor(R.color.comfort_white));
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        mPath.reset();
        mPath.moveTo(0,0);
        mPath.lineTo(width, 0.26f * width);
        mPath.lineTo(width, height);
        mPath.lineTo(0, height);
        mPath.lineTo(0, 0);
        mPath.close();
        canvas.drawPath(mPath,mPaint);
    }
}
