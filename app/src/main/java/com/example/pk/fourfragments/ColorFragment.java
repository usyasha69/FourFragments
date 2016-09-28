package com.example.pk.fourfragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class ColorFragment extends Fragment {

    private int color;

    public static ColorFragment newInstance(int color) {

        Bundle args = new Bundle();
        args.putInt(MainActivity.COLOR_KEY, color);

        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(MainActivity.COLOR_KEY)) {
            color = getArguments().getInt(MainActivity.COLOR_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color, container, false);

        FrameLayout fl = (FrameLayout) view.findViewById(R.id.color_fragment_root);
        fl.setBackgroundColor(color);

        return view;
    }

}
