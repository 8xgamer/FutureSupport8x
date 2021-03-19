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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class installment extends AppCompatActivity {

    TextView month1,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,D1,D2,D3,D4,D5,D6,D7,D8,D9,D10,D11,D12,sum1;
    String url= "http://192.168.0.170/00_fs_system2021/get_installment_record.php";
    Button update,edit;
    MyAdapter adapter;
    String check = "";
    ArrayList<Detail> allDetailArray = new ArrayList<>();
    Detail detail;
    public static ArrayList<Employee> employeeArrayList = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installment);
        check = getIntent().getStringExtra("check");
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
        sum1 = findViewById(R.id.sum);
        update = findViewById(R.id.update_installment);
        edit = findViewById(R.id.edit_installment);
        getdata();
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(installment.this, update_installment_record.class);
                    intent.putExtra("check","create");
                    startActivity(intent);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(installment.this, update_installment_record.class);
                intent.putExtra("check","update");
                startActivity(intent);
            }
        });

    }

    private void getdata() {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object2 = jsonArray.getJSONObject(i);
                        final String month_date = object2.getString("month");
                        final int A1 = object2.getInt("t1");
                        final int A2 = object2.getInt("t2");
                        final int A3 = object2.getInt("t3");
                        final int A4 = object2.getInt("t4");
                        final int A5 = object2.getInt("t5");
                        final int A6 = object2.getInt("t6");
                        final int A7 = object2.getInt("t7");
                        final int A8 = object2.getInt("t8");
                        final int A9 = object2.getInt("t9");
                        final int A10 = object2.getInt("t10");
                        final int A11 = object2.getInt("t11");
                        final int A12 = object2.getInt("t12");
                        String date1 = object2.getString("dat1");
                        String date2 = object2.getString("dat2");
                        String date3 = object2.getString("dat3");
                        String date4 = object2.getString("dat4");
                        String date5 = object2.getString("dat5");
                        String date6 = object2.getString("dat6");
                        String date7 = object2.getString("dat7");
                        String date8 = object2.getString("dat8");
                        String date9 = object2.getString("dat9");
                        String date10 = object2.getString("dat10");
                        String date11 = object2.getString("dat11");
                        String date12 = object2.getString("dat12");
                        final int total_sum = object2.getInt("sumofmonth");

                        SessionManager sessionManager = new SessionManager(getApplicationContext());
                        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
                        String username = userDetails.get(SessionManager.KEY_FULLNAME);
                        String password1 = userDetails.get(SessionManager.KEY_USERNAME);
                        //use this detail to acces login person username

                        if (password1.equals("LSP")){
                            update.setVisibility(View.VISIBLE);
                            edit.setVisibility(View.VISIBLE);
                        }


                      month1.setText(month_date);
                        T1.setText(String.valueOf(A1));
                        T2.setText(String.valueOf(A2));
                        T3.setText(String.valueOf(A3));
                        T4.setText(String.valueOf(A4));
                        T5.setText(String.valueOf(A5));
                        T6.setText(String.valueOf(A6));
                        T7.setText(String.valueOf(A7));
                        T8.setText(String.valueOf(A8));
                        T9.setText(String.valueOf(A9));
                        T10.setText(String.valueOf(A10));
                        T11.setText(String.valueOf(A11));
                        T12.setText(String.valueOf(A12));
                        D1.setText(String.valueOf(date1));
                        D2.setText(String.valueOf(date2));
                        D3.setText(String.valueOf(date3));
                        D4.setText(String.valueOf(date4));
                        D5.setText(String.valueOf(date5));
                        D6.setText(String.valueOf(date6));
                        D7.setText(String.valueOf(date7));
                        D8.setText(String.valueOf(date8));
                        D9.setText(String.valueOf(date9));
                        D10.setText(String.valueOf(date10));
                        D11.setText(String.valueOf(date11));
                        D12.setText(String.valueOf(date12));
                        sum1.setText(String.valueOf(A1+A2+A3+A4+A5+A6+A7+A8+A9+A10+A11+A12));

                        detail = new Detail(month_date,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,A11,A12,date1,date2,date3,date4,date5,date6,date7,date8,date9,date10,date11,date12,total_sum);
                        allDetailArray.add(detail);

    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(installment.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
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
                SessionManager sessionManager = new SessionManager(getApplicationContext());
                sessionManager.logoutUserFromSession();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void logout(){
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
    }

}
