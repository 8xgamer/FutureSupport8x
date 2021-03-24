package com.inphynous.futuresupport8x;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
    int interger1,integer3;
    String str2, str4, str5;
    boolean true_or_false;
    String url = "http://192.168.0.170/00_fs_system2021/get_loan_records.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_status);



        initRecyclerView();
        initData();
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
                    System.out.println(jsonArray);
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject object2 = jsonArray.getJSONObject(i);
                        final int interger1 = object2.getInt("idno");
                        final String str2 = object2.getString("name");
                        final int integer3 = object2.getInt("amount");
                        String str4 = object2.getString("date");
                        String str5 = object2.getString("no_of_month");
                        String true_or_false = object2.getString("bulla");
                        LoanClass loanClass = new LoanClass(interger1,str2,integer3,str4,str5,true_or_false);
                        userList.add(loanClass);
//                        userList.add(new LoanClass(interger1,str2,integer3,str4,str5,true_or_false));
                        adapter= new Adapter(userList,getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();



//                        SessionManager sessionManager = new SessionManager(getApplicationContext());
//                        HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
//                        String username = userDetails.get(SessionManager.KEY_FULLNAME);
//                        String password1 = userDetails.get(SessionManager.KEY_USERNAME);
//                        //use this detail to acces login person username
//
//                        System.out.println(password1);
//                        if (password1.equals("LSP")){
//                            update.setVisibility(View.VISIBLE);
//                            edit.setVisibility(View.VISIBLE);
//                        }


//                        interger1.setText(String.valueOf(serial_no));
//                        interger3.setText(String.valueOf(loan_amt));
//                        T1.setText(String.valueOf(A1));
//                        T2.setText(String.valueOf(A2));
//                        T3.setText(String.valueOf(A3));
//                        T4.setText(String.valueOf(A4));
//                        T5.setText(String.valueOf(A5));
//                        T6.setText(String.valueOf(A6));
//                        T7.setText(String.valueOf(A7));
//                        T8.setText(String.valueOf(A8));
//
//                        detail = new Detail(month_date,A1);
//                        allDetailArray.add(detail);

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