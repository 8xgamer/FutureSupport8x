package com.inphynous.futuresupport8x;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class unique extends AppCompatActivity {
    ListView listView;
    MyAdapter adapter;
    String check = "";
    String url = "https://8xgamer.000webhostapp.com/getdata.php";
    Employee employee;
    Detail detail;
    ArrayList<Detail> allDetailArray = new ArrayList<>();
    String fragacc, fraguser, fragifsc, fragbank;
    boolean fragstatus;
    String fragondate;
    String fraguptodate;
    int fragamt,fraginvestedamt, fragcurrentamt;
    Button button_logout;


    public static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unique);
        check = getIntent().getStringExtra("check");
        listView = findViewById(R.id.mylistview);
        adapter = new MyAdapter(this, employeeArrayList);
        listView.setAdapter(adapter);

        if (check.equals("pd")) {
            employeeArrayList.clear();
            getdata1();
        } else if (check.equals("md")) {
            employeeArrayList.clear();
            getdata();
        }
        getdata2();

    }

    private void getdata2() {
        String url2 = "https://8xgamer.000webhostapp.com/get_p_info.php";


        StringRequest request = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object2 = jsonArray.getJSONObject(i);
                        String username = object2.getString("username");
                        boolean status = (object2.getString("status")).equals("1");
                        int loan = object2.getInt("loan");
                        String accountno = object2.getString("accountno");
                        String ifsc = object2.getString("ifsc");
                        String bankname = object2.getString("bank");
                        String ondate = object2.getString("ondate");
                        String uptodate = object2.getString("uptodate");
                        int investedamt = object2.getInt("invested_amount");
                        int currentamt = object2.getInt("current_amount");
                        detail = new Detail(status,loan, accountno, ifsc, bankname, username,ondate,uptodate,investedamt,currentamt);
                        allDetailArray.add(detail);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(unique.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

    private void getdata1() {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                employeeArrayList.clear();
                try {

                    JSONObject jsonObject = new JSONObject(response);
                    final JSONArray jsonArray = jsonObject.getJSONArray("data");

                    JSONObject object = jsonArray.getJSONObject(0);
                    String id = object.getString("id");
                    final String password1 = object.getString("username");
                    final String fullname = object.getString("password1");
                    final String username = object.getString("fullname");
                    final String mobileno = object.getString("mobileno");
                    final String email = object.getString("email");
                    boolean status = (object.getString("status")).equals("1");
                    int investedamt = object.getInt("invested_amount");
                    int currentamt = object.getInt("current_amount");
                    employee = new Employee(id, fullname, username, password1, mobileno, email,status,investedamt,currentamt);

                    employeeArrayList.add(employee);
                    adapter.notifyDataSetChanged();


                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            String selected = ((TextView) view.findViewById(R.id.txt_name)).getText().toString();

                            Bundle arg = new Bundle();
                            arg.putString("name", selected);
                            for (Detail member : allDetailArray) {
                                if (member.getUsername().equals(selected)) {

                                    fragacc = member.getAccountno();
                                    fragamt = member.getLoan();
                                    fragifsc = member.getIfsc();
                                    fragbank = member.getBankname();
                                    fragstatus = member.isStatus();
                                    fragondate = member.getOndate();
                                    fraguptodate = member.getUptodate();
                                    fraginvestedamt = member.getInvestedamt();
                                    fragcurrentamt = member.getCurrentamt();

                                    arg.putString("fragacc", fragacc);
                                    arg.putString("fragifsc", fragifsc);
                                    arg.putString("fragbank", fragbank);
                                    arg.putInt("loan", fragamt);
                                    arg.putBoolean("fragstatus", fragstatus);
                                    arg.putString("fragondate", fragondate);
                                    arg.putString("fraguptodate", fraguptodate);
                                    arg.putInt("fraginvestedamt",fraginvestedamt);
                                    arg.putInt("fragcurrentamt",fragcurrentamt);
                                    arg.putString("key","2021");
                                }

                            }
                            arg.putString("fullname", fullname);

                            MyDialogueFragment userPopUp = new MyDialogueFragment();
                            userPopUp.setArguments(arg);
                            userPopUp.show(getSupportFragmentManager(), "MyFragment");

                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(unique.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                SessionManager sessionManager = new SessionManager(getApplicationContext());
                HashMap<String, String> userDetails = sessionManager.getUserDetailFromSesion();
                String username = userDetails.get(SessionManager.KEY_FULLNAME);
                params.put("username", username);
                params.put("user", "1");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    public void getdata() {

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                employeeArrayList.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object2 = jsonArray.getJSONObject(i);

                        String id = object2.getString("id");
                        String password1 = object2.getString("username");
                        final String fullname = object2.getString("password1");
                        String username = object2.getString("fullname");
                        String mobileno = object2.getString("mobileno");
                        String email = object2.getString("email");
                        boolean status = (object2.getString("status")).equals("1");
                        int invested_amount = object2.getInt("invested_amount");
                        int current_amount = object2.getInt("current_amount");

                        employee = new Employee(id, fullname, username, password1, mobileno, email,status,invested_amount,current_amount);
                        employeeArrayList.add(employee);
                     Collections.sort(employeeArrayList, new Comparator<Employee>() {
                         @Override
                         public int compare(Employee employee, Employee t1) {
                             boolean b1 = employee.isStatus();
                             boolean b2 = t1.isStatus();
                             return (b1 != b2) ? (b1) ? -1 : 1 : 0;
                         }
                     });
                        adapter.notifyDataSetChanged();
                        for (Detail member : allDetailArray) {

                        }
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                String selected = ((TextView) view.findViewById(R.id.txt_name)).getText().toString();


                                MyDialogueFragment myDialogueFragment = new MyDialogueFragment();
                                Bundle arg = new Bundle();
                                arg.putString("fullname", selected);
                                for (Detail member : allDetailArray) {

                                    if (member.getUsername().equals(selected)) {
                                        System.out.println(member.getUsername());
                                        fragstatus = member.isStatus();
                                        fragacc = member.getAccountno();
                                        fragamt = member.getLoan();
                                        fragifsc = member.getIfsc();
                                        fragbank = member.getBankname();
                                        fragondate = member.getOndate();
                                        fraguptodate = member.getUptodate();
                                        fraginvestedamt = member.getInvestedamt();
                                        fragcurrentamt = member.getCurrentamt();

                                        arg.putString("fragacc", fragacc);
                                        arg.putString("fragifsc", fragifsc);
                                        arg.putString("fragbank", fragbank);
                                        arg.putInt("loan", fragamt);
                                        arg.putBoolean("fragstatus", fragstatus);
                                        arg.putString("key","2022");
                                        arg.putString("fragondate", fragondate);
                                        arg.putString("fraguptodate", fraguptodate);
                                        arg.putInt("fraginvestedamt",fraginvestedamt);
                                        arg.putInt("fragcurrentamt",fragcurrentamt);

                                    }
                                }
                                final MyDialogueFragment userPopUp = new MyDialogueFragment();
                                userPopUp.setArguments(arg);
                                userPopUp.show(getSupportFragmentManager(), "MyFragment");
                                userPopUp.setCancelable(false);

                            }
                        });
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(unique.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user", "2");
                params.put("username", "bbr");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    public void btn_add_activity(View view) {
        startActivity(new Intent(getApplicationContext(), Add_Data_Activity.class));
    }
}