package com.sanat.skysoft.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sanat.skysoft.R;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private Toolbar toolbar;
    private LinearLayout btnBack;
    private TextView mTitle;
    private EditText et_userID, et_password;
    private Button btn_login;
    private String userID, password, login_as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getParams();
        intiWidget();

    }

    private void getParams() {
        Log.i(TAG, "getParams: ");
        Bundle extra = getIntent().getExtras();
        if(extra == null){
            login_as = "";
        } else {
            login_as = extra.getString("login_as");
        }
    }

    private void intiWidget() {
        Log.i(TAG, "intiWidget: ");

        toolbar = findViewById(R.id.toolbar);
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Login");

        btnBack = toolbar.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        et_userID = findViewById(R.id.et_userID);
        et_password = findViewById(R.id.et_password);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUserID() | !validatePassword()) {
                    return;
                }

                userID = et_userID.getText().toString();
                password = et_password.getText().toString();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("login_as", login_as);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
    }

    private boolean validateUserID() {
        String userIDInput = et_userID.getText().toString().trim();

        if (userIDInput.isEmpty()) {
            et_userID.setError("Field can't be empty");
            return false;
        } else if (userIDInput.length() > 30) {
            et_userID.setError("User ID too long");
            return false;
        } else {
            et_userID.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String userIDInput = et_password.getText().toString().trim();

        if (userIDInput.isEmpty()) {
            et_password.setError("Field can't be empty");
            return false;
        } else {
            et_password.setError(null);
            return true;
        }
    }
}
