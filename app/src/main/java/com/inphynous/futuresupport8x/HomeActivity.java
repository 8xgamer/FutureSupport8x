package com.inphynous.futuresupport8x;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {
    RelativeLayout acdetail, pDetail, Mdetail;
    ProgressBar progressBar,progressBar2,progressBar3;
    TextView accdetail,pdata,mdata;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        acdetail = findViewById(R.id.detail);
        accdetail = findViewById(R.id.detailtext);
        pdata = findViewById(R.id.pdnext);
        mdata = findViewById(R.id.membernext);
        pDetail = findViewById(R.id.d2);
        Mdetail = findViewById(R.id.md);
        progressBar = findViewById(R.id.progressD);
        progressBar2 = findViewById(R.id.progress2);
        progressBar3 = findViewById(R.id.progress3);
        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.8305162,75.2842414"));
                startActivity(intent);
            }
        });

        SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();

        final String username = userDetails.get(SessionManager.KEY_USERNAME);
        final String fullname = userDetails.get(SessionManager.KEY_USERNAME);


        acdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accdetail.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
                startActivity(intent);
                accdetail.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);

            }
        });

        pDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdata.setVisibility(View.INVISIBLE);
                progressBar2.setVisibility(View.VISIBLE);
                Intent intent = new Intent(HomeActivity.this, unique.class);
                intent.putExtra("check","pd");
                startActivity(intent);
                pdata.setVisibility(View.VISIBLE);
                progressBar2.setVisibility(View.GONE);
            }
        });
        Mdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdata.setVisibility(View.INVISIBLE);
                progressBar3.setVisibility(View.VISIBLE);
                Intent bhushan = new Intent(HomeActivity.this, unique.class);
                bhushan.putExtra("check","md");
                startActivity(bhushan);
                mdata.setVisibility(View.VISIBLE);
                progressBar3.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                SessionManager sessionManager = new SessionManager(this);
                sessionManager.logoutUserFromSession();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void logout(){
        Toast.makeText(HomeActivity.this, "Logout", Toast.LENGTH_SHORT).show();
    }

    public void onBackPressed() {
            super.onBackPressed();
            finish();
        }


    }

