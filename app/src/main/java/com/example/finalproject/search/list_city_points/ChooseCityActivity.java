package com.example.finalproject.search.list_city_points;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity {
    private ArrayList<City> cityList;
    private ListView listView;
    private CityAdapter cityAdapter;
    private TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);
        mapping();
        Bundle bundle = getIntent().getBundleExtra("valueTitle");

        int drawableLeft = bundle.getInt("drawableLeft");
        Drawable drawable = getResources().getDrawable(drawableLeft);

        String text = bundle.getString("text");

        txtTitle.setHint(text);
        txtTitle.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        listView.setAdapter(cityAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                City city = cityList.get(i);
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle.putString("namepoint", txtTitle.getHint().toString());
                bundle.putString("nameoption", city.getNameCity());
                intent.putExtra("selectedValue", bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void mapping(){
        setListCities();

        txtTitle = (TextView) findViewById(R.id.textviewTitlePoint);
        listView = (ListView) findViewById(R.id.listviewCity);
        cityAdapter = new CityAdapter(ChooseCityActivity.this, R.layout.line_name_city, cityList);
    }

    private void setListCities(){
        cityList = new ArrayList<>();
        cityList.add(new City("Tp Ho Chi Minh"));
        cityList.add(new City("Vinh Long"));
        cityList.add(new City("Soc Trang"));
        cityList.add(new City("Hau Giang"));
        cityList.add(new City("Ca Mau"));
    }
}