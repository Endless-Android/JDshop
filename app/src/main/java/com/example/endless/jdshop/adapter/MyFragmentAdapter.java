package com.example.endless.jdshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MyFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }



    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }


    @Override
    public int getCount() {
        return mFragments.size();
    }
}
