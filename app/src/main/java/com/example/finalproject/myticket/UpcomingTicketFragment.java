package com.example.finalproject.myticket;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalproject.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpcomingTicketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpcomingTicketFragment extends Fragment {

//    private List list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.upcoming_ticket_fragment, container, false);
//        list = view.findViewById(R.id.listviewTicket);

        return inflater.inflate(R.layout.upcoming_ticket_fragment, container, false);
    }
}