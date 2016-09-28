package com.example.pk.fourfragments;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

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
    }

    private void showFragments() {
        final Handler handler = new Handler();

        for (int i = 0; i < fragments.size(); i++) {
            final int finalI = i;

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.root, fragments.get(finalI));
                    ft.commit();

                    Toast.makeText(getApplicationContext(), "Change color: " + finalI
                            , Toast.LENGTH_SHORT).show();
                }
            };

            handler.postDelayed(runnable, 2000);
        }
    }
}
