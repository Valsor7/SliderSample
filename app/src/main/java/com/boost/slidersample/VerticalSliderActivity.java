package com.boost.slidersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class VerticalSliderActivity extends AppCompatActivity {

    private EndlessViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_slider);
        mViewPager = (EndlessViewPager) findViewById(R.id.vp_vertical_card_pager);
        setupVerticalPagerFlow();
    }

    private void setupVerticalPagerFlow() {
        FragmentCoverFlowPagerAdapter adapter = new FragmentCoverFlowPagerAdapter(getSupportFragmentManager());
        EndlessPagerAdapter pagerAdapter = new EndlessPagerAdapter(adapter);
        mViewPager.setAdapter(pagerAdapter);
    }
}
