package com.example.finalproject.myticket;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView ticketsofRouterRecycleView;
    private TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView ticketShowsRecycleView = findViewById(R.id.ticketsofRoute);

        ticketsofRouterRecycleView = findViewById(R.id.ticketsofRoute);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ticketsofRouterRecycleView.setLayoutManager(linearLayoutManager);

        ticketAdapter = new TicketAdapter(getListTicket());
        ticketsofRouterRecycleView.setAdapter(ticketAdapter);
    }

    private List<Ticket> getListTicket() {
        List<Ticket> list = new ArrayList<>();
        list.add(new Ticket(R.drawable.limousine21v1, "Giường nằm 40 chỗ (có toilet)", "9h00 - 14h00", "250.000VNĐ"));
        list.add(new Ticket(R.drawable.limousine21v2, "Giường nằm 40 chỗ", "9h00 - 16h00", "200.000VNĐ"));
        list.add(new Ticket(R.drawable.limousine21v3, "Giường nằm 30 chỗ (có toilet)", "8h00 - 15h00", "280.000VNĐ"));
        list.add(new Ticket(R.drawable.limousine21v4, "Giường nằm 40 chỗ (có toilet)", "10h00 - 16h30", "290.000VNĐ"));
        list.add(new Ticket(R.drawable.limousine21v5, "Giường nằm 20 chỗ (có toilet)", "14h00 - 21h00", "210.000VNĐ"));
        list.add(new Ticket(R.drawable.limousine21v6, "Giường nằm 40 chô (có toilet)", "15h00 - 22h00", "220.000VNĐ"));
        list.add(new Ticket(R.drawable.limousine21v7, "Giường nằm 40 chô (có toilet)", "12h00 - 21h00", "260.000VNĐ"));
        list.add(new Ticket(R.drawable.limousine21v1, "Giường nằm 40 chô (có toilet)", "17h00 - 23h00", "250.000VNĐ"));
        return list;
    }
}