package com.example.lan.testmykotlin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyAdater extends FragmentPagerAdapter {
    List<Fragment> fragments;

    public MyAdater(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragments.size();
    }

}
