package com.example.finalproject.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment{

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleviewContain);
        categoryAdapter = new CategoryAdapter(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        categoryAdapter.setCategoryList(getListCategory());
        recyclerView.setAdapter(categoryAdapter);

        return view;
    }

    private List<Category> getListCategory(){

        List<ChuyenXe> chuyenXeList = new ArrayList<>();
        chuyenXeList.add(new ChuyenXe(R.drawable.vinh_long, "Vĩnh Long", "120.000đ"));
        chuyenXeList.add(new ChuyenXe(R.drawable.ca_mau, "Cà Mau", "120.000đ"));
        chuyenXeList.add(new ChuyenXe(R.drawable.soc_trang, "Sóc Trăng", "120.000đ"));
        chuyenXeList.add(new ChuyenXe(R.drawable.hau_giang, "Hậu Giang", "120.000đ"));

        chuyenXeList.add(new ChuyenXe(R.drawable.vinh_long, "Vĩnh Long", "120.000đ"));
        chuyenXeList.add(new ChuyenXe(R.drawable.ca_mau, "Cà Mau", "120.000đ"));
        chuyenXeList.add(new ChuyenXe(R.drawable.soc_trang, "Sóc Trăng", "120.000đ"));
        chuyenXeList.add(new ChuyenXe(R.drawable.hau_giang, "Hậu Giang", "120.000đ"));

        List<Category> list = new ArrayList<>();
        list.add(new Category("Popular bus routes", chuyenXeList));
        list.add(new Category("Promotions", chuyenXeList));
        return list;
    }

}
