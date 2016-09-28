package com.example.pk.fourfragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String COLOR_KEY = "color";

    private ArrayList<ColorFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAndFillingFragmentsList();
    }

    @Override
    protected void onResume() {
        super.onResume();

        showFragments();
    }

    private void initAndFillingFragmentsList() {
        fragments = new ArrayList<>();

        fragments.add(ColorFragment.newInstance(Color.RED));
        fragments.add(ColorFragment.newInstance(Color.GREEN));
        fragments.add(ColorFragment.newInstance(Color.YELLOW));
        fragments.add(ColorFragment.newInstance(Color.BLUE));

        final int DIFFERENT_COLORS = 4;
        final int REITERATION_NUMBER = 10;

        for (int i = 0; i < REITERATION_NUMBER; i++) {
            //reverse color
            for (int j = DIFFERENT_COLORS - 2; j > 0; j--) {
                fragments.add(fragments.get(j));
            }

            //direct color
            for (int j = 0; j < DIFFERENT_COLORS; j++) {
                fragments.add(fragments.get(j));
            }
        }
    }

    private void showFragments() {
        Handler handler = new Handler();
        int timeCounter = 0;

        for (int i = 0; i < fragments.size(); i++) {
            final int finalI = i;

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.root, fragments.get(finalI));
                    ft.commit();
                }
            };

            handler.postDelayed(runnable, timeCounter);
            timeCounter += 1000;
        }
    }
}
