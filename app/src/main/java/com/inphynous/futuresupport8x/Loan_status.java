package com.inphynous.futuresupport8x;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import java.util.List;

public class Loan_status extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<LoanClass>userList ;
    Adapter adapter;

    Button btn_create1,btn_update1;
    String url = "http://192.168.0.170/00_fs_system2021/get_loan_records.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_status);
        btn_create1=findViewById(R.id.btn_create);
        btn_update1= findViewById(R.id.btn_update);

        initRecyclerView();
        initData();
        btn_create1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loan_status.this,Add_loan_record.class);
                intent.putExtra("check","create");
                startActivity(intent);
            }
        });
        btn_update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loan_status.this, Add_loan_record.class);
                intent.putExtra("check","update");
                startActivity(intent);
            }
        });

    }

    private void initData() {

        userList = new ArrayList<>();
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object2 = jsonArray.getJSONObject(i);
                        final int interger1 = object2.getInt("idno");
                        final String str2 = object2.getString("name");
                        final int integer3 = object2.getInt("amount");
                        String str4 = object2.getString("date");
                        String str5 = object2.getString("no_of_month");
                        String true_or_false = object2.getString("status1");
                        LoanClass loanClass = new LoanClass(interger1,str2,integer3,str4,str5,true_or_false);
                        userList.add(loanClass);
                        adapter= new Adapter(userList,getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();



                        SessionManager sessionManager = new SessionManager(getApplicationContext());
                        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
                        String username = userDetails.get(SessionManager.KEY_FULLNAME);
                        String password1 = userDetails.get(SessionManager.KEY_USERNAME);
                        //use this detail to acces login person username

//                        System.out.println(password1);
                        if (password1.equals("LSP")){
                            btn_create1.setVisibility(View.VISIBLE);
                            btn_update1.setVisibility(View.VISIBLE);
                        }




                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Loan_status.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) ;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }
}