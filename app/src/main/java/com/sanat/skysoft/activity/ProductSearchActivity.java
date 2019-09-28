package com.sanat.skysoft.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sanat.skysoft.R;

public class ProductSearchActivity extends AppCompatActivity {
    private static final String TAG = "ProductSearchActivity";

    private Toolbar toolbar;
    private LinearLayout btnBack;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);

        intiWidget();

    }


    private void intiWidget() {
        Log.i(TAG, "intiWidget: ");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Product Search");

        btnBack = toolbar.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
