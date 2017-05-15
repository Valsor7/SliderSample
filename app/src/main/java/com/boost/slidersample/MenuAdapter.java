package com.boost.slidersample;

import android.support.v7.widget.MenuItemHoverListener;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yaroslav on 15.05.17.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    interface MenuItemListener {
        public void onItemSelected(View v);
    }

    private List<String> mItems;
    private MenuItemListener mItemListener;

    public MenuAdapter(List<String> items, MenuItemListener listener) {
        mItems = items;
        mItemListener = listener;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.onItemSelected(v);
            }
        });
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.mTvItem.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView mTvItem;
        MenuViewHolder(View itemView) {
            super(itemView);
            mTvItem = (TextView) itemView.findViewById(R.id.tv_item_menu);
        }
    }
}
