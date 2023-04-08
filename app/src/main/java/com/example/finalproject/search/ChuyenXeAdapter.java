package com.example.finalproject.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

import java.util.List;

public class ChuyenXeAdapter extends RecyclerView.Adapter<ChuyenXeAdapter.chuyenxeViewholder>{
    private List<ChuyenXe> chuyenXeList;

    public void setChuyenXeList(List<ChuyenXe> list) {
        this.chuyenXeList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public chuyenxeViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chuyenxe, parent, false);
        return new chuyenxeViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chuyenxeViewholder holder, int position) {
        ChuyenXe chuyenXe = chuyenXeList.get(position);
        if(chuyenXe == null){
            return;
        }
        holder.imgChuyenXe.setImageResource(chuyenXe.getResourceImg());
        holder.txtChuyenXe.setText(chuyenXe.getTitle());
        holder.txtGia.setText(chuyenXe.getPrice());
    }

    @Override
    public int getItemCount() {
        if(chuyenXeList != null){
            return chuyenXeList.size();
        }
        return 0;
    }

    public class chuyenxeViewholder extends RecyclerView.ViewHolder {

        private ImageView imgChuyenXe;
        private TextView txtChuyenXe;
        private TextView txtGia;

        public chuyenxeViewholder(@NonNull View itemView) {
            super(itemView);

            imgChuyenXe = itemView.findViewById(R.id.imageviewChuyenXe);
            txtChuyenXe = itemView.findViewById(R.id.textviewChuyenXe);
            txtGia = itemView.findViewById(R.id.textviewGiaChuyenXe);
        }
    }
}
