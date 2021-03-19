package com.inphynous.futuresupport8x;

import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccountActivity extends AppCompatActivity {
    TextView textView,textView2;
    String url = "http://192.168.0.170/00_fs_system2021/getdata.php";
    AccDetail accDetail;
    TextView text1,text2,date1;
    Button edit_acc;
    ArrayList<AccDetail> allDetailArray = new ArrayList<>();
    TextView s1,s2,B1,B2,loangiven,w1,w2,t1,t2,BA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        textView = findViewById(R.id.saving);
        textView2 = findViewById(R.id.textsaving);
        t1 = findViewById(R.id.amount_W_I);
        t2= findViewById(R.id.amount_w_i);
        w1 = findViewById(R.id.Wid_A);
        w2 = findViewById(R.id.wa);
        B1=findViewById(R.id.TN);
        B2=findViewById(R.id.value4);
        s1=findViewById(R.id.Ta);
        s2=findViewById(R.id.value);
        text1=findViewById(R.id.busysaving);
        text2=findViewById(R.id.text2saving);
        loangiven=findViewById(R.id.loan_Q);
        edit_acc=findViewById(R.id.edit);
        date1=findViewById(R.id.date2);
        BA = findViewById(R.id.b_amt);
        getdata();

        edit_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AccountActivity.this, update_acc_detail.class);
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
                        final int total_deposite = object2.getInt("total_deposite");
                        final int total_saving_with_interest = object2.getInt("total_saving_with_interest");
                        final int available_amt_in_acc = object2.getInt("available_amt_in_acc");
                        final int withdrawable_amt = object2.getInt("Withdrawable_amt");
                        final int total_interest = object2.getInt("total_interest");
                        int loan_disbursed_qt = object2.getInt("loan_disbursed");
                        int backup_amount = object2.getInt("backup_amt");
                        int date = object2.getInt("date");
                        final int busy_amt_in_current_year = object2.getInt("busy_amt_in_current_year");


                        SessionManager sessionManager = new SessionManager(getApplicationContext());
                        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
                        String username = userDetails.get(SessionManager.KEY_FULLNAME);
                        String password1 = userDetails.get(SessionManager.KEY_USERNAME);
                        System.out.println(password1);

                        //use this detail to acces login person username


                        if (password1.equals("LSP")){
                        edit_acc.setVisibility(View.VISIBLE);
                        }
                        s2.setVisibility(View.VISIBLE);
                        s2.setText(String.valueOf(available_amt_in_acc));
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(String.valueOf(total_deposite));
                        t2.setVisibility(View.VISIBLE);
                        t2.setText(String.valueOf(total_saving_with_interest));
                        w2.setVisibility(View.VISIBLE);
                        w2.setText(String.valueOf(withdrawable_amt));
                        text1.setVisibility(View.VISIBLE);
                        text1.setText(String.valueOf(busy_amt_in_current_year));
                        B2.setVisibility(View.VISIBLE);
                        B2.setText(String.valueOf(total_interest));
                        loangiven.setText(String.valueOf(loan_disbursed_qt));
                        date1.setText(String.valueOf(date));
                        BA.setText(String.valueOf(backup_amount));


                        /*s1.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                if (!amountacc.isEmpty()) {
                                    s2.setVisibility(View.VISIBLE);
                                    s2.setText(String.valueOf(available_amt_in_acc));
                                }
                            }});
                        textView2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                textView.setVisibility(View.VISIBLE);
                                textView.setText(String.valueOf(total_deposite));
                            }
                        });
                        t1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                t2.setVisibility(View.VISIBLE);
                                t2.setText(String.valueOf(total_saving_with_interest));
                            }
                        });
                        w1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                w2.setVisibility(View.VISIBLE);
                                w2.setText(String.valueOf(withdrawable_amt));
                            }
                        });

                        text2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (!busyamount.isEmpty()) {
                                    text1.setVisibility(View.VISIBLE);
                                    text1.setText(String.valueOf(busy_amt_in_current_year));
                                }
                            }});
                        B1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                B2.setVisibility(0);
                                B2.setText(String.valueOf(total_interest));
                            }
                        });*/

                        accDetail = new AccDetail(total_deposite, total_saving_with_interest, available_amt_in_acc,backup_amount, withdrawable_amt, total_interest, loan_disbursed_qt, busy_amt_in_current_year,date);
                        allDetailArray.add(accDetail);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AccountActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", "3");
                params.put("username", "urbest");
                return params;

            }
        };
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