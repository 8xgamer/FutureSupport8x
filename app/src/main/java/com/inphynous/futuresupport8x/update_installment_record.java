package com.inphynous.futuresupport8x;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class update_installment_record extends AppCompatActivity {
    TextView month1, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, sum1,D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12;
    Button update;
    String url = "http://192.168.0.170/00_fs_system2021/update_installment_sheet.php";

    private static final String TAG = "update_installment_record";
    private TextView mDisplayDate,Da1, Da2, Da3, Da4, Da5, Da6, Da7, Da8, Da9, Da10, Da11, Da12;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    static final int DATE_DIALOG_ID = 0;
    private TextView activeDateDisplay;
    Calendar activeDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_installment_record);
        month1 = findViewById(R.id.month);
        T1 = findViewById(R.id.A1);
        T2 = findViewById(R.id.A2);
        T3 = findViewById(R.id.A3);
        T4 = findViewById(R.id.A4);
        T5 = findViewById(R.id.A5);
        T6 = findViewById(R.id.A6);
        T7 = findViewById(R.id.A7);
        T8 = findViewById(R.id.A8);
        T9 = findViewById(R.id.A9);
        T10 = findViewById(R.id.A10);
        T11 = findViewById(R.id.A11);
        T12 = findViewById(R.id.A12);
        D1 = findViewById(R.id.date1);
        D2 = findViewById(R.id.date2);
        D3 = findViewById(R.id.date3);
        D4 = findViewById(R.id.date4);
        D5 = findViewById(R.id.date5);
        D6 = findViewById(R.id.date6);
        D7 = findViewById(R.id.date7);
        D8 = findViewById(R.id.date8);
        D9 = findViewById(R.id.date9);
        D10 = findViewById(R.id.date10);
        D11 = findViewById(R.id.date11);
        D12 = findViewById(R.id.date12);
        sum1 =findViewById(R.id.addtion_total);
        update = findViewById(R.id.update_installment);

        mDisplayDate =(TextView) findViewById(R.id.month);
        Da1 =(TextView) findViewById(R.id.date1);
        Da2 =(TextView) findViewById(R.id.date2);
        Da3 =(TextView) findViewById(R.id.date3);
        Da4 =(TextView) findViewById(R.id.date4);
        Da5 =(TextView) findViewById(R.id.date5);
        Da6 =(TextView) findViewById(R.id.date6);
        Da7 =(TextView) findViewById(R.id.date7);
        Da8 =(TextView) findViewById(R.id.date8);
        Da9 =(TextView) findViewById(R.id.date9);
        Da10 =(TextView) findViewById(R.id.date10);
        Da11 =(TextView) findViewById(R.id.date11);
        Da12 =(TextView) findViewById(R.id.date12);

        final Calendar startDate = Calendar.getInstance();
        mDisplayDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(mDisplayDate,startDate);

            }
        });

        onClickTime(mDisplayDate,startDate);

        Da1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(Da1,startDate);

            }
        });
        onClickTime(Da1,startDate);

//        updateDisplay(mDisplayDate, startDate);
        Da2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialogue(Da2,startDate);
            }
        });
        onClickTime(Da2,startDate);
        update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
            }
            private void insertdata() {
                final String month = month1.getText().toString().trim();
                final String t1 = T1.getText().toString().trim();
                int t13 = Integer.parseInt(t1);
                final String t2 = T2.getText().toString().trim();
                final String t3 = T3.getText().toString().trim();
                final String t4 = T4.getText().toString().trim();
                final String t5 = T5.getText().toString().trim();
                final String t6 = T6.getText().toString().trim();
                final String t7 = T7.getText().toString().trim();
                final String t8 = T8.getText().toString().trim();
                final String t9 = T9.getText().toString().trim();
                final String t10 = T10.getText().toString().trim();
                final String t11 = T11.getText().toString().trim();
                final String t12 = T12.getText().toString().trim();
                final String d1 = D1.getText().toString().trim();
                final String d2 = D2.getText().toString().trim();
                final String d3 = D3.getText().toString().trim();
                final String d4 = D4.getText().toString().trim();
                final String d5 = D5.getText().toString().trim();
                final String d6 = D6.getText().toString().trim();
                final String d7 = D7.getText().toString().trim();
                final String d8 = D8.getText().toString().trim();
                final String d9 = D9.getText().toString().trim();
                final String d10 = D10.getText().toString().trim();
                final String d11 = D11.getText().toString().trim();
                final String d12 = D12.getText().toString().trim();
                final String sum = sum1.getText().toString().trim();


                System.out.println(d12 +"d12");


                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Updated Successfully")) {
                            Toast.makeText(update_installment_record.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(update_installment_record.this, installment.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(update_installment_record.this, response, Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(update_installment_record.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<String, String>();
                        params.put("month", month);
                        params.put("t1", t1);
                        params.put("t2", t2);
                        params.put("t3", t3);
                        params.put("t4", t4);
                        params.put("t5", t5);
                        params.put("t6", t6);
                        params.put("t7", t7);
                        params.put("t8", t8);
                        params.put("t9", t9);
                        params.put("t10", t10);
                        params.put("t11", t11);
                        params.put("t12", t12);
                        params.put("dat1", d1);
                        params.put("dat2", d2);
                        params.put("dat3", d3);
                        params.put("dat4", d4);
                        params.put("dat5", d5);
                        params.put("dat6", d6);
                        params.put("dat7", d7);
                        params.put("dat8", d8);
                        params.put("dat9", d9);
                        params.put("dat10", d10);
                        params.put("dat11", d11);
                        params.put("dat12", d12);
                        params.put("sum", String.valueOf(Integer.parseInt(t1)+Integer.parseInt(t2)+Integer.parseInt(t3)+Integer.parseInt(t4)+Integer.parseInt(t5)+Integer.parseInt(t6)+Integer.parseInt(t7)+Integer.parseInt(t8)+Integer.parseInt(t9)+Integer.parseInt(t10)+Integer.parseInt(t11) + Integer.parseInt(t12)));


                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(update_installment_record.this);
                requestQueue.add(request);

            }

        });



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

        mDisplayDate.setText( new StringBuilder()
                // Month is 0 based so add 1
                .append(startDate.get(Calendar.MONTH) + 1).append("-")
                .append(startDate.get(Calendar.DAY_OF_MONTH)).append("-")
                .append(startDate.get(Calendar.YEAR)).append(" "));


        };


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






