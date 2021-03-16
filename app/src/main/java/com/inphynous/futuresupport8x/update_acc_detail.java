
package com.inphynous.futuresupport8x;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class update_acc_detail extends AppCompatActivity {
    EditText total_deposite1,total_amount1, amt_in_acc1,backup_amt1,Wid_amt1,total_interest1,loan_qty1,busy_amt1;
    String url = "https://8xgamer.000webhostapp.com/update_account.php";
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_acc_detail);

        total_deposite1= findViewById(R.id.saving);
        total_amount1= findViewById(R.id.amount_w_i);
        amt_in_acc1= findViewById(R.id.value);
        backup_amt1= findViewById(R.id.backup_amount);
        Wid_amt1= findViewById(R.id.wa);
        total_interest1= findViewById(R.id.value4);
        loan_qty1= findViewById(R.id.loan_Q);
        busy_amt1= findViewById(R.id.busysaving);
        update = findViewById(R.id.edit);
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insertdata();
            }
        });
    }
    private void insertdata(){
        final String total_deposite = total_deposite1.getText().toString().trim();
        final String total_saving_with_interest = total_amount1.getText().toString().trim();
        final String amt_in_acc = amt_in_acc1.getText().toString().trim();
        final String backup_amt = backup_amt1.getText().toString().trim();
        final String Wid_amt = Wid_amt1.getText().toString().trim();
        final String total_interest = total_interest1.getText().toString().trim();
        final String loan_qty = loan_qty1.getText().toString().trim();
        final String busy_amt = busy_amt1.getText().toString().trim();

        if (total_deposite.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        } else if (total_saving_with_interest.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }else if (amt_in_acc.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }
        else if (backup_amt.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }
        else if (Wid_amt.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }
        else if (total_interest.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }
        else if (loan_qty.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }
        else if (busy_amt.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }else{
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                   if (response.equalsIgnoreCase("Registered Successfully")) {
                        Toast.makeText(update_acc_detail.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(update_acc_detail.this, AccountActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(update_acc_detail.this, response, Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(update_acc_detail.this, AccountActivity.class);
                    startActivity(intent);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(update_acc_detail.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("total_deposite", total_deposite);
                    params.put("total_saving_with_interest", total_saving_with_interest);
                    params.put("available_amt_in_acc", amt_in_acc);
                    params.put("backup_amt", backup_amt);
                    params.put("Withdrawable_amt", Wid_amt);
                    params.put("total_interest", total_interest);
                    params.put("loan_qty", loan_qty);
                    params.put("busy_amt", busy_amt);


                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(update_acc_detail.this);
            requestQueue.add(request);
        }
        }




}



