package com.inphynous.futuresupport8x;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Installment_history extends AppCompatActivity {
    TableRow TR1,TR2,TR3,TR4,TR5,TR6,TR7,TR8,TR9,TR10,TR11,TR12,TR13;
    EditText T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12;
    TextView month1, sum1, D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12;
    String url = "http://192.168.0.170/00_fs_system2021/get_installment_history.php";
    String url2 = "http://192.168.0.170/00_fs_system2021/insert_sum_installment.php";
    Button btn_get_record,btn_insert_data;
    Spinner spinner_month;
    SpinnerHelper helper;
    String text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installment_history);


        month1 = findViewById(R.id.month);
        sum1=findViewById(R.id.addtion_total);
        btn_insert_data= findViewById(R.id.update_all);
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
        TR1=findViewById(R.id.TR1);
        TR2=findViewById(R.id.TR2);
        TR3=findViewById(R.id.TR3);
        TR4=findViewById(R.id.TR4);
        TR5=findViewById(R.id.TR5);
        TR6=findViewById(R.id.TR6);
        TR7=findViewById(R.id.TR7);
        TR8=findViewById(R.id.TR8);
        TR9=findViewById(R.id.TR9);
        TR10=findViewById(R.id.TR10);
        TR11=findViewById(R.id.TR11);
        TR12=findViewById(R.id.TR12);
        TR13=findViewById(R.id.TR13);
        btn_get_record=findViewById(R.id.get_record);
        spinner_month =findViewById(R.id.spinner_month_history);
        spinner_month.setSelection(0);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Month_Name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_month.setAdapter(adapter);

        spinner_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text1 = parent.getItemAtPosition(position).toString();
                if (parent.getItemAtPosition(position).toString().equals("Select Month")) {
                    ((TextView) view).setTextColor(Color.GRAY);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_get_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_previous_record();
            }
        });
//        SessionManager sessionManager = new SessionManager(getApplicationContext());
//        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
//        String password1 = userDetails.get(SessionManager.KEY_USERNAME);
//        //use this detail to acces login person username
//
//        if (password1.equals("LSP")){
//            btn_insert_data.setVisibility(View.VISIBLE);
//        }
        btn_insert_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update_sum();
            }
        });

    }

    private void update_sum() {
        final String sum_of_installment = sum1.getText().toString().trim();
        StringRequest request = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equalsIgnoreCase("Registered Successfully")) {
                    Toast.makeText(Installment_history.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Installment_history.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Installment_history.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("month", text1);
                params.put("sum_of_installment", sum_of_installment);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        finish();



    }

    private void get_previous_record() {
        if (text1.equals("Select Month")) {
            Toast.makeText(this, "SELECT MONTH", Toast.LENGTH_SHORT).show();
        } else {
            TR1.setVisibility(View.VISIBLE);
            TR2.setVisibility(View.VISIBLE);
            TR3.setVisibility(View.VISIBLE);
            TR4.setVisibility(View.VISIBLE);
            TR5.setVisibility(View.VISIBLE);
            TR6.setVisibility(View.VISIBLE);
            TR7.setVisibility(View.VISIBLE);
            TR8.setVisibility(View.VISIBLE);
            TR9.setVisibility(View.VISIBLE);
            TR10.setVisibility(View.VISIBLE);
            TR11.setVisibility(View.VISIBLE);
            TR12.setVisibility(View.VISIBLE);
            TR13.setVisibility(View.VISIBLE);
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object2 = jsonArray.getJSONObject(i);
//                            final int id = object2.getInt("idno");
//                            final String month_date = object2.getString("month");
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

                            SessionManager sessionManager = new SessionManager(getApplicationContext());
                            HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
                            String password1 = userDetails.get(SessionManager.KEY_USERNAME);
                            //use this detail to acces login person username

                            if (password1.equals("LSP")){
                                btn_insert_data.setVisibility(View.VISIBLE);
                            }


//                            month1.setText(month_date);
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


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }


            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Installment_history.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("MONTH", text1);
//                    params.put("id_for_verification", "get_loan_record");

                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(Installment_history.this);
            requestQueue.add(request);

        }

    }

}