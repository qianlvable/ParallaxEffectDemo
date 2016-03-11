package com.lvable.parallaxeffectdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * @author Cyril Mottier
 */
public class NotifyingScrollView extends ScrollView {
    /**
     * The Scrollview scroll position listener*/
    public interface OnScrollChangedListener {
        /***
         * @param who the view that perform scroll
         * @param l Current horizontal scroll origin.
         * @param t Current vertical scroll origin.
         * @param oldl  Previous horizontal scroll origin.
         * @param oldt	Previous vertical scroll origin.
         */
        void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
    }
    private OnScrollChangedListener mOnScrollChangedListener;

    public NotifyingScrollView(Context context) {
        super(context);
    }
    public NotifyingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NotifyingScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

}
