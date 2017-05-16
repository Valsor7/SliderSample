package com.boost.slidersample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by yaroslav on 15.05.17.
 */

public class MyRecyclerView extends RecyclerView {
    private static final String TAG = "MyRecyclerView";
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        int height = getHeight() * 3;
        return super.fling(velocityX, velocityY > 0 ? height : -height);
    }
}
