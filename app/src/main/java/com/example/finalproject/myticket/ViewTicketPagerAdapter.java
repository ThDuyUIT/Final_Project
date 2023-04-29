package com.example.finalproject.myticket;

import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalproject.authentication.LoginActivity;

public class ViewTicketPagerAdapter extends FragmentStateAdapter {
    public ViewTicketPagerAdapter(@NonNull MyTicketFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new UpcomingTicketFragment();
            case 1:
                return new CompletedTicketFragment();
            case 2:
                return new CancelledTicketFragment();

            default:
                return new UpcomingTicketFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }



}
