package com.lvable.parallaxeffectdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Jiaqi Ning on 4/5/2015.
 */
public class NormalSlidePageFragment extends Fragment {
    ImageView mImageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.normal_slide_page, container, false);
        mImageView = (ImageView)rootView.findViewById(R.id.icon_img);
        int index = getArguments().getInt("index",0);
        switch (index){
            case 1:
                rootView.setBackgroundResource(R.drawable.p2);
                mImageView.setImageResource(R.drawable.icon2);
                break;
            case 2:
                rootView.setBackgroundResource(R.drawable.p3);
                mImageView.setImageResource(R.drawable.icon3);
                break;
        }
        return rootView;
    }
}
