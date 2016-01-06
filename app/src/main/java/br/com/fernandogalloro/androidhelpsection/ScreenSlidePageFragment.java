package br.com.fernandogalloro.androidhelpsection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Responsible for implement the rules of showing the content of the pages
 *
 * Base: http://developer.android.com/intl/pt-br/training/animation/screen-slide.html#viewpager
 */
public class ScreenSlidePageFragment extends Fragment {

    private int resLayout;

    public ScreenSlidePageFragment() {}

    @SuppressLint("ValidFragment")
    public ScreenSlidePageFragment(int resLayout) {
        this.resLayout = resLayout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                resLayout, container, false);

        return rootView;
    }
}
