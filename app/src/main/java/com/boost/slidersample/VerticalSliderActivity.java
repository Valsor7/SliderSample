package com.boost.slidersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.relex.circleindicator.CircleIndicator;

public class VerticalSliderActivity extends AppCompatActivity {

    private VerticalViewPager mViewPager;
    private CircleIndicator mCircleIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_slider);
        mViewPager = (VerticalViewPager) findViewById(R.id.vp_vertical_card_pager);
        mCircleIndicator = (CircleIndicator) findViewById(R.id.ci_vertical_page);
        setupVerticalPagerFlow();
    }

    private void setupVerticalPagerFlow() {
        FragmentCoverFlowPagerAdapter adapter = new FragmentCoverFlowPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setClipChildren(false);
        mCircleIndicator.setViewPager(mViewPager);
    }
}
