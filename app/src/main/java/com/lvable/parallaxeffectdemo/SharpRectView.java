package com.lvable.parallaxeffectdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jiaqi Ning on 28/4/2015.
 */
public class SharpRectView extends View {


    public SharpRectView(Context context) {
        super(context);
    }

    public SharpRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SharpRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        Path path = new Path();
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.comfort_white));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        path.moveTo(0,0);
        path.lineTo(width, 0.26f * width);
        path.lineTo(width, height);
        path.lineTo(0, height);
        path.lineTo(0, 0);
        path.close();
        canvas.drawPath(path,paint);
    }
}
