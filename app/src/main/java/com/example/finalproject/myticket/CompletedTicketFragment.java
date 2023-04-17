package com.example.finalproject.myticket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CompletedTicketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompletedTicketFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.completed_ticket_fragment, container, false);
    }
}