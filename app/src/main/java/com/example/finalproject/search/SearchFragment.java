package com.example.finalproject.search;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.authentication.LoginActivity;
import com.example.finalproject.authentication.RegisterActivity;
import com.example.finalproject.search.calendar.ChooseDateActivity;
import com.example.finalproject.search.list_city_points.ChooseCityActivity;
import com.example.finalproject.search.ticket.ChooseTicketActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.example.finalproject.search.list_city_points.ChooseCityActivity.*;

public class SearchFragment extends Fragment{

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private TextView txtSignin, txtStartPoint, txtEndPoint, txtDate;
    private Button btnSearch;

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new
            ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                Bundle bundle = intent.getBundleExtra("selectedValue");
                if (bundle!= null) {
                    String strNamePoint = bundle.getString("namepoint");
                    String strNameOption = bundle.getString("nameoption");
                    if (strNamePoint.equals("Start point")) {
                        txtStartPoint.setText(strNameOption);
                    } else {
                        txtEndPoint.setText(strNameOption);
                    }
                }

                long selectedDate = intent.getLongExtra("selectedDate", 0);
                if (selectedDate != 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(selectedDate);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                    txtDate.setText(dateFormat.format(calendar.getTime()));
                }
            }
        }
    });

//    private ActivityResultLauncher<Intent> activityCalendarResultLauncher = registerForActivityResult(new
//            ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//        @Override
//        public void onActivityResult(ActivityResult result) {
//            if(result.getResultCode() == RESULT_OK){
//                Intent intent = result.getData();
//                Bundle bundle = intent.getBundleExtra("selectedValue");
//                String strNamePoint = bundle.getString("namepoint");
//                String strNameOption = bundle.getString("nameoption");
//                if(strNamePoint.equals("Start point")){
//                    txtStartPoint.setText(strNameOption);
//                }else {
//                    txtEndPoint.setText(strNameOption);
//                }
//            }
//        }
//    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        mapping(view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        categoryAdapter.setCategoryList(getListCategory());
        recyclerView.setAdapter(categoryAdapter);

        txtSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        txtStartPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChooseCityActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("text", "Start point");
                bundle.putInt("drawableLeft", R.drawable.point_start);

                intent.putExtra("valueTitle", bundle);
                activityResultLauncher.launch(intent);
                //startActivity(intent);
            }
        });

        txtEndPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChooseCityActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("text", "Where to?");
                bundle.putInt("drawableLeft", R.drawable.point_end);

                intent.putExtra("valueTitle", bundle);
                activityResultLauncher.launch(intent);
                //startActivity(intent);
            }
        });

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChooseDateActivity.class);
                activityResultLauncher.launch(intent);
                //startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChooseTicketActivity.class);
                startActivity(intent);
            }
        });

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

        List<KhuyenMai> khuyenMaiList = new ArrayList<>();
        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_1, "Tổng hợp chương trình khuyến mãi trong tháng"));
        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_2, "Danh cho khách hàng mới - giảm đến 25%"));
        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_3, "Giới thiệu bạn mới - nhận qua siêu khủng"));
        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_4, "Ưu đãi siêu bất ngờ khi đặt vé"));

        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_1, "Tổng hợp chương trình khuyến mãi trong tháng"));
        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_2, "Danh cho khách hàng mới - giảm đến 25%"));
        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_3, "Giới thiệu bạn mới - nhận qua siêu khủng"));
        khuyenMaiList.add(new KhuyenMai(R.drawable.promotion_4, "Ưu đãi siêu bất ngờ khi đặt vé"));

        List<Category> list = new ArrayList<>();
        list.add(new Category("Popular bus routes", chuyenXeList));
        list.add(new Category(khuyenMaiList, "Promotions"));

        return list;
    }

    private void mapping(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleviewContain);
        categoryAdapter = new CategoryAdapter(getContext());
        txtSignin = (TextView) view.findViewById(R.id.textviewSignin);
        txtStartPoint = (TextView) view.findViewById(R.id.textViewStartPoint);
        txtEndPoint = (TextView) view.findViewById(R.id.textViewEndPoint);
        txtDate = (TextView) view.findViewById(R.id.textViewDate);
        btnSearch = (Button) view.findViewById(R.id.buttonSearchTickets);
    }

}
