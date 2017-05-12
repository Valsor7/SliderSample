package com.boost.slidersample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by yaroslav on 08.05.17.
 */

public class FragmentCoverFlowPagerAdapter extends FragmentPagerAdapter {
    private static final int FRAGMENTS_AMOUNT = 5;

    public FragmentCoverFlowPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentContainer.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return FRAGMENTS_AMOUNT;
    }
}
