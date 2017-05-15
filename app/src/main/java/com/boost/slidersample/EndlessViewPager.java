package com.boost.slidersample;

/**
 * Created by yaroslav on 12.05.17.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

public class EndlessViewPager extends ViewPager {
    private static final String TAG = "EndlessViewPager";
    public EndlessViewPager(Context context) {
        super(context);
    }

    public EndlessViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);

        setCurrentItem(0);
    }

    @Override
    public void setCurrentItem(int item) {

        setCurrentItem(item, false);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        Log.d(TAG, "setCurrentItem() called with: item = [" + item + "], smoothScroll = [" + smoothScroll + "]");
        if (getAdapter().getCount() == 0) {
            super.setCurrentItem(item, smoothScroll);
            return;
        }
        item = getOffsetAmount() + (item % getAdapter().getCount());
        Log.d(TAG, "setCurrentItem: calculated " + item);
        super.setCurrentItem(item, smoothScroll);
        Log.d(TAG, "setCurrentItem: after");
    }

    @Override
    public int getCurrentItem() {
        if (getAdapter().getCount() == 0) {
            return super.getCurrentItem();
        }
        int position = super.getCurrentItem();
        if (getAdapter() instanceof EndlessPagerAdapter) {
            EndlessPagerAdapter infAdapter = (EndlessPagerAdapter) getAdapter();

            return (position % infAdapter.getRealCount());
        } else {
            return super.getCurrentItem();
        }
    }

    private int getOffsetAmount() {
        if (getAdapter().getCount() == 0) {
            return 0;
        }
        if (getAdapter() instanceof EndlessPagerAdapter) {
            EndlessPagerAdapter infAdapter = (EndlessPagerAdapter) getAdapter();

            return infAdapter.getRealCount() * 100;
        } else {
            return 0;
        }
    }
}