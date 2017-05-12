package com.boost.slidersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by yaroslav on 08.05.17.
 */

public class FragmentContainer extends Fragment {

    private static final String TAG = "FragmentContainer";
    private static final String EXTRA_POSITION = "EXTRA_POSITION";
    private ImageView mImage;

    public static FragmentContainer newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt(EXTRA_POSITION, position);
        FragmentContainer fragment = new FragmentContainer();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImage = (ImageView)view.findViewById(R.id.iv_container);
        int position = 1;
        if (getArguments() != null){
            position = (int) getArguments().get(EXTRA_POSITION);
        }
        String fileName = "screen"+position;
        Log.d(TAG, "onViewCreated: " + fileName);
        int resId = getResources().getIdentifier(fileName, "drawable", getActivity().getPackageName());
        Glide.with(getActivity()).load(resId).into(mImage);
    }
}
