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
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class installment extends AppCompatActivity {

    TextView month1,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,D1,D2,D3,D4,D5,D6,D7,D8,D9,D10,D11,D12;
    String url= "http://192.168.0.170/00_fs_system2021/update_installment_sheet.php";
    Button update;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installment);
        month1 = findViewById(R.id.month);
        T1 = findViewById(R.id.A1);
        T2 = findViewById(R.id.A2);
        T3 = findViewById(R.id.A3);
        T4 = findViewById(R.id.A4);
        T5 = findViewById(R.id.A5);
        T6 = findViewById(R.id.A6);
        T7 = findViewById(R.id.A7);
        T8 = findViewById(R.id.A8);
        T9 = findViewById(R.id.A9);
        T10 = findViewById(R.id.A10);
        T11 = findViewById(R.id.A11);
        T12 = findViewById(R.id.A12);
        D1 = findViewById(R.id.date1);
        D2 = findViewById(R.id.date2);
        D3 = findViewById(R.id.date3);
        D4 = findViewById(R.id.date4);
        D5 = findViewById(R.id.date5);
        D6 = findViewById(R.id.date6);
        D7 = findViewById(R.id.date7);
        D8 = findViewById(R.id.date8);
        D9 = findViewById(R.id.date9);
        D10 = findViewById(R.id.date10);
        D11 = findViewById(R.id.date11);
        D12 = findViewById(R.id.date12);
        update = findViewById(R.id.update_installment);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(installment.this, update_installment_record.class);
                    startActivity(intent);

            }
        });



    }

}
