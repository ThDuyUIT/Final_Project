package com.example.finalproject.myticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private List<Ticket> mListTicket;

    public TicketAdapter(List<Ticket> mListTicket) {
        this.mListTicket = mListTicket;
    }
    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ticket = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticketsofroute, parent, false);
        return new TicketViewHolder(ticket);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Ticket ticket = mListTicket.get(position);
        if (ticket == null) {
            return;
        }

        holder.image_bus.setImageResource(ticket.getResourceID());
        holder.name_bus.setText(ticket.getName());
        holder.time_ticket.setText(ticket.getTime());
        holder.price_ticket.setText(ticket.getPrice());
    }

    @Override
    public int getItemCount() {
        if (mListTicket != null) {
            return mListTicket.size();
        }
        return 0;
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_bus;
        private TextView name_bus;
        private TextView time_ticket;
        private TextView price_ticket;
        private androidx.constraintlayout.widget.ConstraintLayout layout_ticket;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);

            layout_ticket = itemView.findViewById(R.id.layoutTicket);
            image_bus = itemView.findViewById(R.id.imageBus);
            name_bus = itemView.findViewById(R.id.busName);
            time_ticket = itemView.findViewById(R.id.timeTicket);
            price_ticket = itemView.findViewById(R.id.priceTicket);
        }
    }
}
