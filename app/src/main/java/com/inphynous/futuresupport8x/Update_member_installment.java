package com.inphynous.futuresupport8x;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Update_member_installment extends AppCompatActivity {
    SpinnerHelper helper;
    Spinner spinner_member;
    EditText inst_amount;
    String url="http://192.168.0.170/00_fs_system2021/update.php";
    TextView date;
    String text1;
    Button button_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_member_installment);

        spinner_member = findViewById(R.id.spinner_member);
        inst_amount = findViewById(R.id.inst_amt);
        date = findViewById(R.id.on_date);
        button_submit = findViewById(R.id.btn_submit);
        spinner_member.setSelection(0);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Member, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_member.setAdapter(adapter);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_new_membe_record();
            }
        });

        spinner_member.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text1 = parent.getItemAtPosition(position).toString();
                if (parent.getItemAtPosition(position).toString().equals("SELECT MEMBER")) {
                    ((TextView) view).setTextColor(Color.GRAY);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void create_new_membe_record() {
        final String amount = inst_amount.getText().toString().trim();


        if (text1.equals("SELECT MEMBER")) {
            Toast.makeText(this, "Select Member First", Toast.LENGTH_SHORT).show();
        } else if (amount.isEmpty()) {
            Toast.makeText(this, "Enter Amount First", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if (response.equalsIgnoreCase("Registered Successfully")) {
                        Toast.makeText(Update_member_installment.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(Update_member_installment.this, Loan_status.class);
//                        startActivity(intent);

                    } else {
                        Toast.makeText(Update_member_installment.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Update_member_installment.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("member_name", text1);
                    params.put("Amount", amount);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
            finish();


        }
    }
}