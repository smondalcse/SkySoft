package com.sanat.skysoft.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.sanat.skysoft.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LedgerBookActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener{
    private static final String TAG = "LedgerBookActivity";

    private Toolbar toolbar;
    private LinearLayout btnBack;
    private TextView mTitle, txtStartTime, txtEndTime;
    private ImageButton btn_starttime, btn_endtime;

    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal;
    String pressValue = "none";
    String startDate, endDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledger_book);

        intiWidget();
        setInitDate();
    }

    private void intiWidget() {
        Log.i(TAG, "intiWidget: ");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Ledger Book");

        btnBack = toolbar.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtStartTime = findViewById(R.id.txtStartTime);
        txtEndTime = findViewById(R.id.txtEndTime);

        btn_starttime = findViewById(R.id.btn_starttime);
        btn_starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressValue = "start";
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR); // current year
                month = c.get(Calendar.MONTH); // current month
                day = c.get(Calendar.DAY_OF_MONTH); // current day

                DatePickerDialog datePickerDialog = new DatePickerDialog(LedgerBookActivity.this, LedgerBookActivity.this, year, month, day);
                datePickerDialog.show();
            }
        });
        btn_endtime = findViewById(R.id.btn_endtime);
        btn_endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pressValue = "end";
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR); // current year
                month = c.get(Calendar.MONTH); // current month
                day = c.get(Calendar.DAY_OF_MONTH); // current day
                int test = c.get(Calendar.AM_PM);
                Log.d(TAG, "AM_PM: " + test);

                DatePickerDialog datePickerDialog = new DatePickerDialog(LedgerBookActivity.this, LedgerBookActivity.this, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    public void setInitDate(){
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String date_time = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Log.d(TAG, "setInitDate: " + date);

        startDate = date;
        endDate = date;

        // txtStartTime.setText("Date: " + date_time);
        txtEndTime.setText(date_time);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY); // current Hour
        minute = c.get(Calendar.MINUTE); // current minute

        if(pressValue.equalsIgnoreCase("start")){
            startDate = yearFinal + "-" + monthFinal + "-" + dayFinal;
            txtStartTime.setText(startDate);

        } else if(pressValue.equalsIgnoreCase("end")){
            endDate = yearFinal + "-" + monthFinal + "-" + dayFinal;
            txtEndTime.setText(endDate);
        }
    }


}
