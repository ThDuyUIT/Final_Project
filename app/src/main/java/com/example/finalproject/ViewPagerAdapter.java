package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject.myaccount.MyAccountFragment;
import com.example.finalproject.myticket.MyTicketFragment;
import com.example.finalproject.search.SearchFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new SearchFragment();
            case 1:
                return new MyTicketFragment();
            case 2:
                return new MyAccountFragment();
            default:
                return new SearchFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
