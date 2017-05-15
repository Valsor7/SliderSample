package com.boost.slidersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaroslav on 08.05.17.
 */

public class SliderActivity extends AppCompatActivity {
    private static final String TAG = "SliderActivity";
    MyRecyclerView mRvSlides;
    private RelativeLayout mMainLayout;
    private RecyclerView mRvMenu;
    private FloatingActionButton mFabMenu;
    private MyAdapter mSlidesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        mRvSlides = (MyRecyclerView) findViewById(R.id.rv_slider_vertical);
        mSlidesAdapter = new MyAdapter();
        mRvSlides.setAdapter(mSlidesAdapter);
        mRvSlides.setLayoutManager(new LinearLayoutManager(this));

        mRvSlides.getLayoutManager().scrollToPosition(Integer.MAX_VALUE / 2);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRvSlides);
        mMainLayout = (RelativeLayout) findViewById(R.id.main_container);
        mRvMenu = (RecyclerView) findViewById(R.id.rv_menu);
        mFabMenu = (FloatingActionButton) findViewById(R.id.fab_menu);
        mFabMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Slide slide = new Slide();
                slide.setSlideEdge(Gravity.BOTTOM);
                TransitionManager.beginDelayedTransition(mMainLayout, slide);
                animateMenuAppearance(mRvMenu);
            }
        });

        setupMenuRv();
    }

    private void setupMenuRv() {
        List<String> menuItems = new ArrayList<>();
        menuItems.addAll(Arrays.asList(getResources().getStringArray(R.array.menu)));

        mRvMenu.setLayoutManager(new LinearLayoutManager(this));
        mRvMenu.setAdapter(new MenuAdapter(menuItems, new MenuAdapter.MenuItemListener() {
            @Override
            public void onItemSelected(View v) {
                int selectedPos = mRvMenu.getChildAdapterPosition(v) + 1;
                int realPos = mSlidesAdapter.getCurrentPosition();
                int fakePos = (realPos % mSlidesAdapter.getItemCount()) + 1;
                if (selectedPos < fakePos){
                    int posDifference = fakePos - selectedPos;
                    mRvSlides.scrollToPosition(realPos - posDifference);
                } else {
                    int posDifference = selectedPos - fakePos;
                    mRvSlides.scrollToPosition(realPos + posDifference);
                }
                animateMenuAppearance(mRvMenu);
            }
        }));
    }

    private void animateMenuAppearance(View view) {
        boolean isVisible = view.getVisibility() == View.VISIBLE;
        view.setVisibility(isVisible ? View.GONE : View.VISIBLE);
    }
}
