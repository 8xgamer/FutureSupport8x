package com.inphynous.futuresupport8x;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountActivity extends AppCompatActivity {
    TextView textView, textView2;
    String url = "http://192.168.0.170/00_fs_system2021/update_invested_amt.php";
    String url2 = "http://192.168.0.170/00_fs_system2021/get_collected_amt.php";
    AccDetail accDetail;
    TextView text1, text2, date1;
    TextView l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    Detail detail;
    Button edit_acc;
    ArrayList<Detail> allDetailArray = new ArrayList<>();
    //    ArrayList<AccDetail> allDetailArray = new ArrayList<>();
    public TextView s1, s2, B1, B2, loangiven, w1, w2, t1, t2, BA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        textView = findViewById(R.id.saving);
        textView2 = findViewById(R.id.textsaving);
        t1 = findViewById(R.id.amount_W_I);
        t2 = findViewById(R.id.amount_w_i);
        w1 = findViewById(R.id.Wid_A);
        w2 = findViewById(R.id.w2);
        B1 = findViewById(R.id.TN);
        B2 = findViewById(R.id.value4);
        s1 = findViewById(R.id.Ta);
        s2 = findViewById(R.id.value);
        text1 = findViewById(R.id.busysaving);
        text2 = findViewById(R.id.text2saving);
        loangiven = findViewById(R.id.loan_Q);
        edit_acc = findViewById(R.id.edit);
        date1 = findViewById(R.id.date2);
        BA = findViewById(R.id.b_amt);
        l1= findViewById(R.id.l1);
        l2= findViewById(R.id.l2);
        l3= findViewById(R.id.l3);
        l4= findViewById(R.id.l4);
        l5= findViewById(R.id.l5);
        l6= findViewById(R.id.l6);
        l7= findViewById(R.id.l7);
        l8= findViewById(R.id.l8);
        l9= findViewById(R.id.l9);
        l10= findViewById(R.id.l10);
        l11= findViewById(R.id.l11);
        l12= findViewById(R.id.l12);

        getbusyamount();
        update_invested_amount();

        edit_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AccountActivity.this, update_acc_detail.class);
                startActivity(intent);
            }
        });
    }

    private void update_invested_amount() {
        final String sum1 = l1.getText().toString().trim();
        final String sum2 = l2.getText().toString().trim();
        final String sum3 = l3.getText().toString().trim();
        final String sum4 = l4.getText().toString().trim();
        final String sum5 = l5.getText().toString().trim();
        final String sum6 = l6.getText().toString().trim();
        final String sum7 = l7.getText().toString().trim();
        final String sum8 = l8.getText().toString().trim();
        final String sum9 = l9.getText().toString().trim();
        final String sum10 = l10.getText().toString().trim();
        final String sum11 = l11.getText().toString().trim();
        final String sum12 = l12.getText().toString().trim();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equalsIgnoreCase("Registered Successfully")) {
                    Toast.makeText(AccountActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(AccountActivity.this, response, Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AccountActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("laxman", sum1);
                params.put("bhushan", sum2);
                params.put("tushar", sum3);
                params.put("krushna", sum4);
                params.put("bhagwan", sum5);
                params.put("sandip", sum6);
                params.put("sachin", sum7);
                params.put("jagdish", sum8);
                params.put("shubham", sum9);
                params.put("rahul", sum10);
                params.put("pradyum", sum11);
                params.put("yogesh", sum12);


                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(AccountActivity.this);
        requestQueue.add(request);


    }

    public void getbusyamount() {
        StringRequest request = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data4");
                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object2 = jsonArray.getJSONObject(i);
                        final int busy_amount = object2.getInt("busy_amount");
                        final int total_deposited_amt = object2.getInt("total_collected_amt");
                        final int sum_interest = object2.getInt("sum_of_interest");
                        int loan_disbursed_qty = object2.getInt("loan_disbursed");
                        final int backup_amount = object2.getInt("backup_amt");
                        final int laxman =object2.getInt("laxman");
                        final int bhushan =object2.getInt("bhushan");
                        final int tushar =object2.getInt("tushar");
                        final int krushna =object2.getInt("krushna");
                        final int bhagwan =object2.getInt("bhagwan");
                        final int sandip =object2.getInt("sandip");
                        final int sachin =object2.getInt("sachin");
                        final int jagdish =object2.getInt("jagdish");
                        final int shubham =object2.getInt("shubham");
                        final int rahul =object2.getInt("rahul");
                        final int pradyum =object2.getInt("pradyum");
                        final int yogesh =object2.getInt("yogesh");

                        SessionManager sessionManager = new SessionManager(getApplicationContext());
                        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
                        String username = userDetails.get(SessionManager.KEY_FULLNAME);
                        String password1 = userDetails.get(SessionManager.KEY_USERNAME);
                        //use this detail to acces login person username

                        System.out.println(password1);
                        if (password1.equals("LSP")){
                            edit_acc.setVisibility(View.VISIBLE);
                        }


                        int total_saving_with_int = total_deposited_amt + sum_interest;
                        int amount_in_acc = total_deposited_amt + sum_interest - busy_amount;
                        int withdrawal_amt = amount_in_acc - backup_amount;
                        System.out.println(withdrawal_amt);

                        text1.setText(String.valueOf(busy_amount));
                        textView.setText(String.valueOf(total_deposited_amt));
                        B2.setText(String.valueOf(sum_interest));
                        t2.setText(String.valueOf(total_saving_with_int));
                        s2.setText(String.valueOf(amount_in_acc));
                        w2.setText(String.valueOf(withdrawal_amt));
                        loangiven.setText(String.valueOf(loan_disbursed_qty));
                        BA.setText(String.valueOf(backup_amount));
                        l1.setText(String.valueOf(laxman));
                        l2.setText(String.valueOf(bhushan));
                        l3.setText(String.valueOf(tushar));
                        l4.setText(String.valueOf(krushna));
                        l5.setText(String.valueOf(bhagwan));
                        l6.setText(String.valueOf(sandip));
                        l7.setText(String.valueOf(sachin));
                        l8.setText(String.valueOf(jagdish));
                        l9.setText(String.valueOf(shubham));
                        l10.setText(String.valueOf(rahul));
                        l11.setText(String.valueOf(pradyum));
                        l12.setText(String.valueOf(yogesh));



                        accDetail = new AccDetail(total_deposited_amt,busy_amount,backup_amount,total_saving_with_int,amount_in_acc,withdrawal_amt, loan_disbursed_qty);
                        allDetailArray.add(detail);

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
        });
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
        switch (item.getItemId()) {
            case R.id.logout:
                SessionManager sessionManager = new SessionManager(getApplicationContext());
                sessionManager.logoutUserFromSession();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void logout() {
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
    }

}