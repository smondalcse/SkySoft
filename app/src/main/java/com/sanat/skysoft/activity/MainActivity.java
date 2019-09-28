package com.sanat.skysoft.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sanat.skysoft.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btn_company, btn_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
    }

    private void initWidget() {
        Log.i(TAG, "initWidget: ");
        btn_company = findViewById(R.id.btn_company);
        btn_company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("login_as", "company");
                startActivity(intent);
            }
        });


        btn_customer = findViewById(R.id.btn_customer);
        btn_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("login_as", "customer");
                startActivity(intent);
            }
        });
    }
}
