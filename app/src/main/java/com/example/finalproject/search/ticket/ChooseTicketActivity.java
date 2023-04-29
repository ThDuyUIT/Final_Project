package com.example.finalproject.search.ticket;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.search.list_city_points.ChooseCityActivity;
import com.example.finalproject.search.list_city_points.City;
import com.example.finalproject.search.list_city_points.CityAdapter;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class ChooseTicketActivity extends AppCompatActivity{
    private ArrayList<Ticket> tickets;
    private ListView listView;
    private RecyclerView recyclerView;
    private TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ticket);
        mapping();

        //listView.setAdapter(ticketAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(ticketAdapter);

    }

    private void mapping(){
        setListTicket();

        //listView = (ListView) findViewById(R.id.listviewTicket);
        //ticketAdapter = new TicketAdapter(ChooseTicketActivity.this, R.layout.line_ticket, tickets);

        recyclerView = (RecyclerView) findViewById(R.id.recycleviewTicket);
        ticketAdapter = new TicketAdapter(tickets);
    }

    private void setListTicket(){
        tickets = new ArrayList<>();
        tickets.add(new Ticket(R.drawable.limousine21v1, "Giường nằm 40 chỗ có toilet", "9:00 - 11:30", "250.000VND"));
        tickets.add(new Ticket(R.drawable.limousine21v1, "Giường nằm 40 chỗ có toilet", "9:00 - 11:30", "250.000VND"));
        tickets.add(new Ticket(R.drawable.limousine21v1, "Giường nằm 40 chỗ có toilet", "9:00 - 11:30", "250.000VND"));
        tickets.add(new Ticket(R.drawable.limousine21v1, "Giường nằm 40 chỗ có toilet", "9:00 - 11:30", "250.000VND"));
        tickets.add(new Ticket(R.drawable.limousine21v1, "Giường nằm 40 chỗ có toilet", "9:00 - 11:30", "250.000VND"));
    }
}
