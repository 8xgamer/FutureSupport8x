package com.inphynous.futuresupport8x;

import android.content.Intent;
import android.nfc.Tag;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    String url = "http://192.168.0.170/00_fs_system2021/login.php";
    Button button;
    TextView admin;
    String username, password1;
    EditText inputusername, inputpassword;
    Button signup;
    ProgressBar progressBar;
    Employee employee;
    public static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StrictMode.enableDefaults();
        button = findViewById(R.id.login);
        admin=findViewById(R.id.add);
        admin.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         Intent addmin= new Intent(LoginActivity.this, admin.class);
                                         startActivity(addmin);

                                     }
                                 });
        inputusername = findViewById(R.id.username);
        inputpassword = findViewById(R.id.password);
        signup = findViewById(R.id.log);
        progressBar = findViewById(R.id.progressD);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, signup.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkdata();
            }
        });
    }

    private void checkdata() {
        username = inputusername.getText().toString();
        password1 = inputpassword.getText().toString();
        button.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        if (TextUtils.isEmpty(username)) {
            inputusername.setError("Enter username and password correct");
        } else if (TextUtils.isEmpty(password1)) {
            inputpassword.setError("enter password");
        } else {
            StringRequest request = new StringRequest(Request.Method.POST, url
                    , new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response", "this is response" + response);

                    if (response.equalsIgnoreCase("LOGIN FAILED")) {
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        button.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    } else {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object2 = jsonArray.getJSONObject(i);

                                String id = object2.getString("id");
                                String username5 = object2.getString("fullname");
                                String password2 = object2.getString("username");
                                String fullname = object2.getString("password1");
                                String mobileno = object2.getString("mobileno");
                                String email = object2.getString("email");
                                SessionManager sessionManager = new SessionManager(getApplicationContext());
                                sessionManager.createLoginSession(fullname, username5, mobileno, email);
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                    button.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.GONE);


                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }


                }


            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    button.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }


            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("username", username);
                    params.put("password1", password1);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
            requestQueue.add(request);

        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}