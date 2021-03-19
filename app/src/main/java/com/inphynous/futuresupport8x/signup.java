package com.inphynous.futuresupport8x;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    EditText fullname, username1, password, mobileno1, email0;
    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname = findViewById(R.id.fullname);
        username1 = findViewById(R.id.username);
        email0 = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        mobileno1 = findViewById(R.id.contact);
        btn_insert = findViewById(R.id.register);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insertdata();
            }
        });

    }

    private void insertdata() {
        final String name = fullname.getText().toString().trim();
        final String username = username1.getText().toString().trim();
        final String password1 = password.getText().toString().trim();
        final String mobileno = mobileno1.getText().toString().trim();
        final String email = email0.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
            return;
        } else if (username.isEmpty()) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
            return;
        } else if (password1.isEmpty()) {
            Toast.makeText(this, "Enter Password again", Toast.LENGTH_SHORT).show();
            return;
        } else if (mobileno.isEmpty()) {
            Toast.makeText(this, "Enter Mobile No correct", Toast.LENGTH_SHORT).show();
            return;
        } else if (email.isEmpty()) {
            Toast.makeText(this, "Enter Email Correctly", Toast.LENGTH_SHORT).show();
            return;
        } else {
            StringRequest request = new StringRequest(Request.Method.POST,
                    "http://192.168.0.170/00_fs_system2021/savedata.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equalsIgnoreCase("Registered Successfullly")) {
                                Toast.makeText(signup.this, "Registered Successfullly", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(signup.this, LoginActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(signup.this, response, Toast.LENGTH_SHORT).show();

                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(signup.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("username", username);
                    params.put("password1", password1);
                    params.put("fullname", name);
                    params.put("mobileno", mobileno);
                    params.put("email", email);


                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(signup.this);
            requestQueue.add(request);

        }

    }


    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}