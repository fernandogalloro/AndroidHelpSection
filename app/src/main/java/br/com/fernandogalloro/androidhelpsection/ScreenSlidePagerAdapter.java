package br.com.fernandogalloro.androidhelpsection;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Responsible for handle the rules of navigation among the pages
 *
 * Base: http://developer.android.com/intl/pt-br/training/animation/screen-slide.html#viewpager
 */
public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private List<Integer> listLayout;

    public ScreenSlidePagerAdapter(FragmentManager fm, List<Integer> listLayout) {
        super(fm);
        this.listLayout = listLayout;
    }

    @Override
    public Fragment getItem(int position) {
        Integer resLayout = listLayout.get(position);
        return new ScreenSlidePageFragment(resLayout);
    }

    @Override
    public int getCount() {
        return listLayout.size();
    }
}
