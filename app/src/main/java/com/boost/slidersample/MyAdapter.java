package com.boost.slidersample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(position + 1);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static final class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        Context mContext;
        int mCurrentPos;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.iv_container);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mContext.getString(R.string.position) + mCurrentPos, Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(int position){
            mCurrentPos = position;
            String fileName = "p"+position;
            Log.d(TAG, "bind: " + fileName);
            int resId = itemView.getResources().getIdentifier(fileName, mContext.getString(R.string.drawable_res), itemView.getContext().getPackageName());
            Glide.with(itemView.getContext()).load(resId).into(mImage);
        }
    }
}
