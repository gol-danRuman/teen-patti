package com.backspace.teenpatti.SwipeTab;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backspace.teenpatti.R;
import com.backspace.teenpatti.fragment.FAQ;
import com.backspace.teenpatti.fragment.Facts;
import com.backspace.teenpatti.fragment.PlayerMode;
import com.backspace.teenpatti.fragment.Setting;

/**
 * Created by Backspace on 11/16/2016.
 */
public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;
    private FragmentActivity myContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        ViewGroup x = (ViewGroup) inflater.inflate(R.layout.tab_layout,container,false);
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */

            viewPager.setAdapter(new MyAdapter(myContext.getSupportFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;


    }
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }


    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position) {
                case 0: // Fragment # 0 - This will show FAQ in second tabbed
                    return new FAQ();
                case 1: // Fragment # 0 - This will show Facts in second tabbed
                    return new Facts();
                default:
                    return new TabFragment();
            }
        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "FAQs";
                case 1 :
                    return "Fact";
            }
            return null;
        }
    }

}
