package com.boost.slidersample;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yaroslav on 12.05.17.
 */

public class EndlessPagerAdapter extends PagerAdapter {

    private static final String TAG = "InfinitePagerAdapter";

    private PagerAdapter adapter;

    public EndlessPagerAdapter(PagerAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getCount() {
        if (getRealCount() == 0) {
            return 0;
        }

        return Integer.MAX_VALUE;
    }

    /**
     * @return the {@link #getCount()} result of the wrapped adapter
     */
    public int getRealCount() {
        return adapter.getCount();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int virtualPosition = position % getRealCount();

        // only expose virtual position to the inner adapter
        return adapter.instantiateItem(container, virtualPosition);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int virtualPosition = position % getRealCount();

        // only expose virtual position to the inner adapter
        adapter.destroyItem(container, virtualPosition, object);
    }

    /*
     * Delegate rest of methods directly to the inner adapter.
     */

    @Override
    public void finishUpdate(ViewGroup container) {
        adapter.finishUpdate(container);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return adapter.isViewFromObject(view, object);
    }

    @Override
    public void restoreState(Parcelable bundle, ClassLoader classLoader) {
        adapter.restoreState(bundle, classLoader);
    }

    @Override
    public Parcelable saveState() {
        return adapter.saveState();
    }

    @Override
    public void startUpdate(ViewGroup container) {
        adapter.startUpdate(container);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int virtualPosition = position % getRealCount();
        return adapter.getPageTitle(virtualPosition);
    }

    @Override
    public float getPageWidth(int position) {
        return adapter.getPageWidth(position);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        adapter.setPrimaryItem(container, position, object);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        adapter.unregisterDataSetObserver(observer);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        adapter.registerDataSetObserver(observer);
    }

    @Override
    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return adapter.getItemPosition(object);
    }
}