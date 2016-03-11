package com.lvable.parallaxeffectdemo;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Jiaqi Ning on 28/4/2015.
 */
public class ParallaxTransformer implements ViewPager.PageTransformer {
    private int[] resIds;
    private float speedEffect;
    private float distanceEffect;

    /**
     * The parallax effect PageTransformer
     * @param speed the parallax effect common move speed
     * @param viewDistance the object`s view view distance(景深）
     * @param resIds view`s res id that will have parallax effect
     * @param isSpeedReverse moving forward or backward
     * */
    public ParallaxTransformer(float speed,float viewDistance,
                               int[] resIds,boolean isSpeedReverse){
        this.resIds = resIds;
        this.speedEffect = speed;
        this.distanceEffect = viewDistance;
        if (isSpeedReverse)
            this.speedEffect *= -1;
    }
    @Override
    public void transformPage(View page, float position) {

       float moveLength = page.getWidth() * speedEffect;
        for (int i = 0;i < resIds.length; i++){
            View view = page.findViewById(resIds[i]);
            if (view != null){
                view.setTranslationX(moveLength * position);
            }
            moveLength *= distanceEffect;
        }

    }
}
