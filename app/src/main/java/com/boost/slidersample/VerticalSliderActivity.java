package com.boost.slidersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerticalSliderActivity extends AppCompatActivity {
    private static final String TAG = "VerticalSliderActivity";
    private EndlessViewPager mViewPager;
    private RecyclerView mRvMenu;
    private FloatingActionButton mFabMenu;
    private RelativeLayout mMainLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_slider);

        mMainLayout = (RelativeLayout) findViewById(R.id.main_container);
        mViewPager = (EndlessViewPager) findViewById(R.id.vp_vertical_card_pager);
        mRvMenu = (RecyclerView) findViewById(R.id.rv_menu);
        mFabMenu = (FloatingActionButton) findViewById(R.id.fab_menu);
        mFabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Slide slide = new Slide();
                slide.setSlideEdge(Gravity.BOTTOM);
//                TransitionManager.beginDelayedTransition(mMainLayout, slide);
                animateMenuAppearence(mRvMenu);
            }
        });

        setupVerticalPagerFlow();
        setupMenuRv();
    }

    private void animateMenuAppearence(View view) {
        boolean isVisible = view.getVisibility() == View.VISIBLE;
        view.setVisibility(isVisible ? View.GONE : View.VISIBLE);
    }

//    private void toggleFabVisibility() {
//        boolean isVisible = mFabMenu.getVisibility() == View.VISIBLE;
//        mFabMenu.setVisibility(isVisible ? View.GONE : View.VISIBLE);
//    }

    private void setupMenuRv() {
        List<String> menuItems = new ArrayList<>();
        menuItems.addAll(Arrays.asList(getResources().getStringArray(R.array.menu)));

        mRvMenu.setLayoutManager(new LinearLayoutManager(this));
        mRvMenu.setAdapter(new MenuAdapter(menuItems, new MenuAdapter.MenuItemListener() {
            @Override
            public void onItemSelected(View v) {
                int pos = mRvMenu.getChildAdapterPosition(v);
                Log.d(TAG, "onItemSelected: " + pos);
                mViewPager.setCurrentItem(pos);
                animateMenuAppearence(mRvMenu);
            }
        }));
    }

    private void setupVerticalPagerFlow() {
        FragmentCoverFlowPagerAdapter adapter = new FragmentCoverFlowPagerAdapter(getSupportFragmentManager());
        EndlessPagerAdapter pagerAdapter = new EndlessPagerAdapter(adapter);
        mViewPager.setAdapter(pagerAdapter);

    }
}
