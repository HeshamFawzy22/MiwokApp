package com.abofa.miwokapp.ui.Adapter;

import com.abofa.miwokapp.R;
import com.abofa.miwokapp.ui.ColorsFragment;
import com.abofa.miwokapp.ui.FamilyFragment;
import com.abofa.miwokapp.ui.NumbersFragment;
import com.abofa.miwokapp.ui.PhrasesFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Fragment fragment;
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment = new NumbersFragment();
                break;
            case 1:
                fragment = new FamilyFragment();
                break;
            case 2:
                fragment = new ColorsFragment();
                break;
            case 3:
                fragment = new PhrasesFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position){
            case 0:
                title = "Numbers";
                break;
            case 1:
                title = "Family";
                break;
            case 2:
                title = "Colors";
                break;
            case 3:
                title = "Phrases";
                break;
        }
        return title;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
