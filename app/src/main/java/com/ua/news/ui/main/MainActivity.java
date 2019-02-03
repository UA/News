package com.ua.news.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;

import com.ua.news.R;
import com.ua.news.ui.base.BaseActivity;
import com.ua.news.ui.custom.BottomNavigationViewEx;
import com.ua.news.ui.main.feed.FeedFragment;
import com.ua.news.ui.main.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    //Fragments Tags
    public static final String Feed_Fragment = "Feed_Fragment";
    public static final String Settings_Fragment = "Settings_Fragment";
    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;// used for ViewPager adapter
    private FragmentTransaction transaction;
    @BindView(R.id.navigation)
    protected BottomNavigationViewEx navigation;
    @BindView(R.id.viewpager)
    protected ViewPager viewPager;
    private MenuItem prevMenuItem;
    private int previousPosition = -1;

    private BottomNavigationViewEx.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        int position = 0;
        switch (item.getItemId()) {
                    case R.id.navigation_feed:
                        //mFragment = new FeedFragment();
                        //loadFragment(mFragment, MainActivity.Feed_Fragment);
                        viewPager.setCurrentItem(0);
                        position = 0;
                        return true;
                    case R.id.navigation_settings:
                        //mFragment = new SettingsFragment();
                        //loadFragment(mFragment, MainActivity.Settings_Fragment);
                        viewPager.setCurrentItem(1);
                        position = 1;
                        return true;
                }
        if(previousPosition != position) {
           viewPager.setCurrentItem(position, false);
            previousPosition = position;
        }
                return true;
            };

    private ViewPager.OnPageChangeListener mAddOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int position) {
//            if (prevMenuItem != null) {
//                prevMenuItem.setChecked(false);
//            }
//            else
//            {
//                navigation.getMenu().getItem(0).setChecked(false);
//            }
//            Log.d("page", "onPageSelected: "+position);
//            navigation.getMenu().getItem(position).setChecked(true);
//            prevMenuItem = navigation.getMenu().getItem(position);

            if (position >= 2)// 2 is center
                position++;// if page is 2, need set bottom item to 3, and the same to 3 -> 4
            navigation.setCurrentItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUnBinder(ButterKnife.bind(this));

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(mAddOnPageChangeListener);

        navigation.enableAnimation(false);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(false);

        setupViewPager();
    }

    @Override
    protected void setUp() {

    }

    private void setupViewPager() {
        final Fragment feed = new FeedFragment();
        final Fragment settings = new SettingsFragment();

        fragments = new ArrayList<>(2);
        fragments.add(feed);
        fragments.add(settings);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void loadFragment(Fragment fragment, String tag) {
        // load fragment

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();


    }

}
