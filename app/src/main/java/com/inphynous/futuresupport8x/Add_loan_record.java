package com.inphynous.futuresupport8x;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Add_loan_record extends AppCompatActivity {
    Spinner spinner_member, spinner_status, spinner_month;
    EditText loan_amount, no_of_month, returned_amt_1, returned_amt_2, returned_amt_3, remaining_amt, Int_on_loan;
    TextView create_head, update_head, from_date1, upto_date, rdate1, rdate2, rdate3;
    TableRow tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr10, tr11, tr12, tr13, tr14;
    SpinnerHelper helper;
    ArrayList<Detail4> allDetailArray4 = new ArrayList<>();
    Detail4 detail4;
    String url = "http://192.168.0.170/00_fs_system2021/create_loan_record.php";
    String url2 = "http://192.168.0.170/00_fs_system2021/get_loan_record_for_update.php";
    String url3 = "http://192.168.0.170/00_fs_system2021/update_loan_record.php";
    Button button1, btn_getdata, button2;
    public String TAG, text2, text1, text3;
    private TextView activeDateDisplay;
    Calendar activeDate;
    MyAdapter adapter;
    String check = "";
    public String text, test;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    static final int DATE_DIALOG_ID = 0;

    public static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loan_record);
        button1 = findViewById(R.id.add_new);
        button2 = findViewById(R.id.update_old);
        btn_getdata = findViewById(R.id.btn_getdata);
        loan_amount = findViewById(R.id.loan_amt);
        from_date1 = findViewById(R.id.from_date1);
        upto_date = findViewById(R.id.upto_date1);
        returned_amt_1 = findViewById(R.id.returned_amt_1);
        returned_amt_2 = findViewById(R.id.returned_amt_2);
        returned_amt_3 = findViewById(R.id.returned_amt_3);
        rdate1 = findViewById(R.id.date1);
        rdate2 = findViewById(R.id.date2);
        rdate3 = findViewById(R.id.date3);
        remaining_amt = findViewById(R.id.remaining_amt);
        Int_on_loan = findViewById(R.id.Int_on_loan);
        helper = new SpinnerHelper();
        spinner_member = findViewById(R.id.spinner_member);
        spinner_status = findViewById(R.id.status_view);
        spinner_month = findViewById(R.id.spinner_month);
        spinner_member.setSelection(0);
        spinner_status.setSelection(0);
        spinner_month.setSelection(0);
        create_head = findViewById(R.id.create_head);
        update_head = findViewById(R.id.update_head);
        tr1 = findViewById(R.id.tr1);
        tr2 = findViewById(R.id.tr2);
        tr3 = findViewById(R.id.tr3);
        tr4 = findViewById(R.id.tr4);
        tr5 = findViewById(R.id.tr5);
        tr6 = findViewById(R.id.tr6);
        tr7 = findViewById(R.id.tr7);
        tr8 = findViewById(R.id.tr8);
        tr9 = findViewById(R.id.tr9);
        tr10 = findViewById(R.id.tr10);
        tr11 = findViewById(R.id.tr11);
        tr12 = findViewById(R.id.tr12);
        tr13 = findViewById(R.id.tr13);
        tr14 = findViewById(R.id.tr14);
        check = getIntent().getStringExtra("check");


        if (check.equals("create")) {
            employeeArrayList.clear();
            create_head.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
            tr6.setVisibility(View.INVISIBLE);
//            tr7.setVisibility(View.INVISIBLE);
//            tr8.setVisibility(View.INVISIBLE);
//            tr9.setVisibility(View.INVISIBLE);
//            tr10.setVisibility(View.INVISIBLE);
//            tr11.setVisibility(View.INVISIBLE);
//            tr12.setVisibility(View.INVISIBLE);
            tr13.setVisibility(View.INVISIBLE);
//            tr14.setVisibility(View.INVISIBLE);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createdata();
                }
            });

        } else {
            employeeArrayList.clear();
            update_head.setVisibility(View.VISIBLE);
            btn_getdata.setVisibility(View.VISIBLE);
            tr2.setVisibility(View.INVISIBLE);
            tr3.setVisibility(View.INVISIBLE);
            tr4.setVisibility(View.INVISIBLE);
            tr5.setVisibility(View.INVISIBLE);
            tr6.setVisibility(View.INVISIBLE);
//            tr7.setVisibility(View.INVISIBLE);
//            tr8.setVisibility(View.INVISIBLE);
//            tr9.setVisibility(View.INVISIBLE);
//            tr10.setVisibility(View.INVISIBLE);
//            tr11.setVisibility(View.INVISIBLE);
//            tr12.setVisibility(View.INVISIBLE);
            tr13.setVisibility(View.INVISIBLE);
            tr14.setVisibility(View.INVISIBLE);


            button2.setVisibility(View.INVISIBLE);
            btn_getdata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getdata();

                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
// this activity is to send data to the table using get_loan_record.php
//                    Intent intent = new Intent(Add_loan_record.this, Loan_status.class);
//                    startActivity(intent);
                    update_in_process();

                }
            });
        }

        final Calendar startDate = Calendar.getInstance();
        from_date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(from_date1, startDate);
            }
        });
        upto_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(upto_date, startDate);
            }
        });
        rdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(rdate1, startDate);
            }
        });
        rdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(rdate2, startDate);
            }
        });
        rdate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(rdate3, startDate);
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Member, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_member.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.status, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_status.setAdapter(adapter2);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_month.setAdapter(adapter3);


// for spinner1 get member name
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

// for spinner2 to get status of loan
        spinner_status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text2 = parent.getItemAtPosition(position).toString();
                if (parent.getItemAtPosition(position).toString().equals("Select status")) {
                    ((TextView) view).setTextColor(Color.GRAY);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
// for spinner2 to get number of month loan taken
        spinner_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text3 = parent.getItemAtPosition(position).toString();
                if (parent.getItemAtPosition(position).toString().equals("Select Month")) {
                    ((TextView) view).setTextColor(Color.GRAY);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void update_in_process() {
        final String loan_amount1 = loan_amount.getText().toString().trim();
        final String from_date2 = from_date1.getText().toString().trim();
        final String upto_date1 = upto_date.getText().toString().trim();
        final String return_amt_1 = returned_amt_1.getText().toString().trim();
        final String return_amt_2 = returned_amt_2.getText().toString().trim();
        final String return_amt_3 = returned_amt_3.getText().toString().trim();
        final String date1 = rdate1.getText().toString().trim();
        final String date2 = rdate2.getText().toString().trim();
        final String date3 = rdate3.getText().toString().trim();
        final String intereset_loan = Int_on_loan.getText().toString().trim();

        if (text3.equals("Select Due Month")) {
            Toast.makeText(this, "Select Month", Toast.LENGTH_SHORT).show();
        } else if (text2.equals("Select status")) {
            Toast.makeText(this, "SELECT Status", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.POST, url3, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if (response.equalsIgnoreCase("Registered Successfully")) {
                        Toast.makeText(Add_loan_record.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Add_loan_record.this, Loan_status.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Add_loan_record.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_loan_record.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("member_name", text1);
                    params.put("Amount_loan", loan_amount1);
//            params.put("ondate", from_date2); Dates are already updated need not update again.
//            params.put("uptodate", upto_date1);
                    params.put("returned_amt_1", return_amt_1);
                    params.put("returned_amt_2", return_amt_2);
                    params.put("returned_amt_3", return_amt_3);
                    params.put("date1", date1);
                    params.put("date2", date2);
                    params.put("date3", date3);
//            params.put("remaining_amt", remainig_amt); this amount automatically update using calculation
                    params.put("number_of_month", text3);
                    params.put("interest_loan", intereset_loan);
                    params.put("status", text2);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
            finish();
        }

    }

    private void getdata() {
        if (text1.equals("SELECT MEMBER")) {
            Toast.makeText(this, "SELECT MEMBER", Toast.LENGTH_SHORT).show();
        } else {
            tr2.setVisibility(View.VISIBLE);
            tr3.setVisibility(View.VISIBLE);
            tr4.setVisibility(View.VISIBLE);
            tr5.setVisibility(View.VISIBLE);
            tr6.setVisibility(View.VISIBLE);
            tr13.setVisibility(View.VISIBLE);
            tr14.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);

            StringRequest request = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("data");


                        JSONObject object2 = jsonArray.getJSONObject(0);
                        String name = object2.getString("name");
                        int loan_amt = object2.getInt("amount");
                        int month2 = object2.getInt("no_of_month");
                        String ondate = object2.getString("on_date");
                        String uptodate = object2.getString("uptodate");
                        int return_amt_1 = object2.getInt("return_amt_1");
                        int return_amt_2 = object2.getInt("return_amt_2");
                        int return_amt_3 = object2.getInt("return_amt_3");
                        String date1 = object2.getString("date1");
                        String date2 = object2.getString("date2");
                        String date3 = object2.getString("date3");
                        int remain_amt = loan_amt - return_amt_1 - return_amt_2 - return_amt_3;
                        int interest = object2.getInt("int_on_loan");
                        String test = object2.getString("no_of_month");
                        if (test.equals("1")) {
                            tr7.setVisibility(View.VISIBLE);
                            tr8.setVisibility(View.VISIBLE);
                        } else if (test.equals("2")) {
                            tr7.setVisibility(View.VISIBLE);
                            tr8.setVisibility(View.VISIBLE);
                            tr9.setVisibility(View.VISIBLE);
                            tr10.setVisibility(View.VISIBLE);
                        } else {
                            tr7.setVisibility(View.VISIBLE);
                            tr8.setVisibility(View.VISIBLE);
                            tr9.setVisibility(View.VISIBLE);
                            tr10.setVisibility(View.VISIBLE);
                            tr11.setVisibility(View.VISIBLE);
                            tr12.setVisibility(View.VISIBLE);
                        }

                        loan_amount.setText(String.valueOf(loan_amt));
                        from_date1.setText(String.valueOf(ondate));
                        Int_on_loan.setText(String.valueOf(interest));
                        returned_amt_1.setText(String.valueOf(return_amt_1));
                        returned_amt_2.setText(String.valueOf(return_amt_2));
                        returned_amt_3.setText(String.valueOf(return_amt_3));
                        remaining_amt.setText(String.valueOf(remain_amt));
                        upto_date.setText(String.valueOf(uptodate));
                        rdate1.setText(String.valueOf(date1));
                        rdate2.setText(String.valueOf(date2));
                        rdate3.setText(String.valueOf(date3));


                        detail4 = new Detail4(loan_amt, ondate, month2, interest, return_amt_1, remain_amt, uptodate, return_amt_2, return_amt_3, date1, date2, date3);
                        allDetailArray4.add(detail4);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }


            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_loan_record.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("member_name", text1);
                    params.put("id_for_verification", "get_loan_record");

                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(Add_loan_record.this);
            requestQueue.add(request);

        }
    }


    private void createdata() {

        final String loan_amount1 = loan_amount.getText().toString().trim();
        final String from_date2 = from_date1.getText().toString().trim();
        final String upto_date1 = upto_date.getText().toString().trim();
        final String return_amt = returned_amt_1.getText().toString().trim();
        final String remainig_amt = remaining_amt.getText().toString().trim();
        final String intereset_loan = Int_on_loan.getText().toString().trim();
//        final String no_month = no_of_month.getText().toString().trim();


        if (loan_amount1.isEmpty()) {
            Toast.makeText(this, "Enter value", Toast.LENGTH_SHORT).show();
        } else if (text1.equals("SELECT MEMBER")) {
            Toast.makeText(this, "SELECT MEMBER", Toast.LENGTH_SHORT).show();
        } else if (from_date2.isEmpty()) {
            Toast.makeText(this, "Select date", Toast.LENGTH_SHORT).show();
        } else if (upto_date1.isEmpty()) {
            Toast.makeText(this, "Select Date", Toast.LENGTH_SHORT).show();
        } else if (return_amt.isEmpty()) {
            Toast.makeText(this, "Enter Return Amount", Toast.LENGTH_SHORT).show();
        } else if (remainig_amt.isEmpty()) {
            Toast.makeText(this, "Enter Remaining Amount", Toast.LENGTH_SHORT).show();
        } else if (intereset_loan.isEmpty()) {
            Toast.makeText(this, "Enter Interest", Toast.LENGTH_SHORT).show();
        } else if (text2.equals("Select status")) {
            Toast.makeText(this, "SELECT Status", Toast.LENGTH_SHORT).show();
        } else {
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Registered Successfully")) {
                        Toast.makeText(Add_loan_record.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Add_loan_record.this, Loan_status.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Add_loan_record.this, response, Toast.LENGTH_SHORT).show();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Add_loan_record.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("member_name", text1);
                    params.put("Amount_loan", loan_amount1);
                    params.put("date1", from_date2);
                    params.put("date2", upto_date1);
                    params.put("returned_amt", return_amt);
                    params.put("remaining_amt", remainig_amt);
                    params.put("number_of_month", text3);
                    params.put("interest_loan", intereset_loan);
                    params.put("status", text2);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Add_loan_record.this);
            requestQueue.add(request);
            finish();
        }
    }

    @SuppressWarnings("deprecation")
    public void showDateDialogue(TextView mDisplayDate, Calendar startDate) {
        activeDateDisplay = mDisplayDate;
        activeDate = startDate;
        showDialog(DATE_DIALOG_ID);

    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            activeDate.set(Calendar.YEAR, year);
            activeDate.set(Calendar.MONTH, month);
            activeDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            onClickTime(activeDateDisplay, activeDate);
            unregisterDateDisplay();

        }
    };

    private void unregisterDateDisplay() {
        activeDateDisplay = null;
        activeDate = null;
    }

    private void onClickTime(final TextView mDisplayDate, Calendar startDate) {
        // this code is for adding 0 in a single digit of date and month
        //code start :{

        if (startDate.get(Calendar.MONTH) < 9 && startDate.get(Calendar.DAY_OF_MONTH) < 10) {
            mDisplayDate.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(startDate.get(Calendar.YEAR) + "0")
                    .append((startDate.get(Calendar.MONTH) + 1) + "0")
                    .append(startDate.get(Calendar.DAY_OF_MONTH)));
        } else if (startDate.get(Calendar.MONTH) < 9 && startDate.get(Calendar.DAY_OF_MONTH) >= 10) {
            mDisplayDate.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(startDate.get(Calendar.YEAR) + "0")
                    .append(startDate.get(Calendar.MONTH) + 1)
                    .append(startDate.get(Calendar.DAY_OF_MONTH)));
        } else if (startDate.get(Calendar.MONTH) > 8 && startDate.get(Calendar.DAY_OF_MONTH) < 10) {
            mDisplayDate.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(startDate.get(Calendar.YEAR))
                    .append((startDate.get(Calendar.MONTH) + 1) + "0")
                    .append(startDate.get(Calendar.DAY_OF_MONTH)));
        } else {
            mDisplayDate.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(startDate.get(Calendar.YEAR))
                    .append(startDate.get(Calendar.MONTH) + 1)
                    .append(startDate.get(Calendar.DAY_OF_MONTH)));
        }
        System.out.println(mDisplayDate);
// } code End :this code is for adding 0 in a single digit of date and month


    }

    ;


    @SuppressWarnings("deprecation")
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, dateSetListener, activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
        }
        return null;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        switch (id) {
            case DATE_DIALOG_ID:
                ((DatePickerDialog) dialog).updateDate(activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
                break;
        }
    }
}