package com.qcc.qiuser.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
//viewpager和fragment结合使用的adapter

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentsList;
    private Fragment fragment;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }


    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        if (arg0 > fragmentsList.size()) {
            fragmentsList.add(null);
        }
        return fragmentsList.get(arg0);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
