package com.sanat.skysoft.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sanat.skysoft.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "HomeActivity";

    private TextView txt_companyName;
    private CardView btn_menu_ldgBook, btn_menu_customer_detail, btn_menu_product_search, btn_menu_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intiWidget();
    }

    private void intiWidget() {
        Log.i(TAG, "intiWidget: ");

        txt_companyName = findViewById(R.id.txt_companyName);
        Typeface myCustomeFont = Typeface.createFromAsset(getAssets(), "fonts/starcruiser.ttf");
        txt_companyName.setTypeface(myCustomeFont);

        btn_menu_ldgBook = findViewById(R.id.btn_menu_ldgBook);
        btn_menu_customer_detail = findViewById(R.id.btn_menu_customer_detail);
        btn_menu_product_search = findViewById(R.id.btn_menu_product_search);
        btn_menu_profile = findViewById(R.id.btn_menu_profile);

        btn_menu_ldgBook.setOnClickListener(this);
        btn_menu_customer_detail.setOnClickListener(this);
        btn_menu_product_search.setOnClickListener(this);
        btn_menu_profile.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        // Menu button click listener
        Log.d(TAG, "onClick: Menu Button OnClickListener");

        switch (view.getId()){
            case R.id.btn_menu_ldgBook:
                Log.d(TAG, "onClick: map Button click");
                //Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
                Intent ldgIntent = new Intent(HomeActivity.this, LedgerBookActivity.class);
                startActivity(ldgIntent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;
            case R.id.btn_menu_customer_detail:
                Log.d(TAG, "onClick: map Button click");
                //Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
                Intent customerIntent = new Intent(HomeActivity.this, CustomerDetailsActivity.class);
                startActivity(customerIntent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;
            case R.id.btn_menu_product_search:
                Log.d(TAG, "onClick: map Button click");
                //Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
                Intent productIntent = new Intent(HomeActivity.this, ProductSearchActivity.class);
                startActivity(productIntent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;
            case R.id.btn_menu_profile:
                Log.d(TAG, "onClick: map Button click");
                //Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
                Intent profileIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
                overridePendingTransition(R.anim.enter, R.anim.exit);
                break;

        }
    }

}
