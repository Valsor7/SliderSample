package com.boost.slidersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import me.crosswall.lib.coverflow.CoverFlow;

/**
 * Created by yaroslav on 08.05.17.
 */

public class Slider3DActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider3d);
        mViewPager = (ViewPager) findViewById(R.id.vp_card_pager);
        setupCoverFlow();
    }

    private void setupCoverFlow() {
        FragmentCoverFlowPagerAdapter adapter = new FragmentCoverFlowPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setClipChildren(false);
        new CoverFlow.Builder()
                .with(mViewPager)
                .scale(0.1f)
                .pagerMargin(getResources().getDimension(R.dimen.pager_margin))
                .spaceSize(0f)
                .rotationY(25f)
                .build();
    }
}
