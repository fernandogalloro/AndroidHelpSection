package br.com.fernandogalloro.androidhelpsection;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class HelpActivity extends AppCompatActivity {

    private static final int RES_COLOR_SELECTED_VIEW = R.color.colorHelpSelected;

    private static final int RES_COLOR_UNSELECTED_VIEW = R.color.colorHelpUnSelected;

    private ViewPager viewPager;

    private PagerAdapter pagerAdapter;

    private LinearLayout llContainerStepIndicators;

    private List<Integer> resLayoutList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        populateResLayoutList();

        viewPager = (ViewPager) findViewById(R.id.viewPagerHelp);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), resLayoutList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(onPageChangeListener);

        llContainerStepIndicators = (LinearLayout) findViewById(R.id.llHelpContainerStepIndicators);
        buildStepIndicatorsViews();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void populateResLayoutList() {
        // Pages (fragments)
        // they will be displayed in the order they are added
        resLayoutList.add(R.layout.fragment_help_p1);
        resLayoutList.add(R.layout.fragment_help_p2);
        resLayoutList.add(R.layout.fragment_help_p3);
        resLayoutList.add(R.layout.fragment_help_p4);
        resLayoutList.add(R.layout.fragment_help_p5);
    }

    private void buildStepIndicatorsViews() {
        // add views according to the number of layouts
        for (int i = 0; i < resLayoutList.size(); i++) {
            llContainerStepIndicators.addView(getStepIndicatorView(RES_COLOR_UNSELECTED_VIEW));
        }

        // paint the first view to give selection effect
        View firstView = llContainerStepIndicators.getChildAt(0);
        llContainerStepIndicators.removeView(firstView);
        llContainerStepIndicators.addView(getStepIndicatorView(RES_COLOR_SELECTED_VIEW), 0);
    }

    private View getStepIndicatorView(int cor) {
        View view = new View(this);
        view.setBackgroundColor(getResources().getColor(cor));
        LinearLayout.LayoutParams layoutParams
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.width = Utils.convertDpToPixels(this, 10);
        layoutParams.height = Utils.convertDpToPixels(this, 10);
        layoutParams.rightMargin = Utils.convertDpToPixels(this, 5);
        layoutParams.leftMargin = Utils.convertDpToPixels(this, 5);
        view.setLayoutParams(layoutParams);
        return view;
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            // paint like unselected all views of the container
            for (int i = 0; i < llContainerStepIndicators.getChildCount(); i++) {
                View childAt = llContainerStepIndicators.getChildAt(i);
                childAt.setBackgroundColor(getResources().getColor(RES_COLOR_UNSELECTED_VIEW));
            }

            // paint like selected the corresponding view
            View childAt = llContainerStepIndicators.getChildAt(position);
            childAt.setBackgroundColor(getResources().getColor(RES_COLOR_SELECTED_VIEW));
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}
