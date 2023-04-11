package com.example.finalproject.search.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ChooseDateActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private long selectedDate;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);

        mapping();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, day);
                selectedDate = cal.getTimeInMillis();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("selectedDate", selectedDate);
                Log.d("AA", selectedDate + "");
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

    private void mapping(){
        calendarView = findViewById(R.id.calendarview);
        btnConfirm = (Button) findViewById(R.id.buttonConfirm);
    }
}