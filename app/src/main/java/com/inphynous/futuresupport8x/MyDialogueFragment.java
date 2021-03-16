package com.inphynous.futuresupport8x;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.android.volley.toolbox.Volley;
import com.google.android.material.internal.ViewOverlayImpl;

import java.util.zip.Inflater;

public class MyDialogueFragment extends DialogFragment {
    TextView textView, usernm, usernm1, usernm2, usernm3, usernm4, usernm5, usernm6,investedamt,currentamt;
    LinearLayout linearupto, linearonto,bankrow, accountrow, ifscrow,current_amt,invested_amt;
    Button imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.info_fragment, container, false);
        textView = v.findViewById(R.id.name);
        usernm = v.findViewById(R.id.amount1);
        usernm4 = v.findViewById(R.id.ondate);
        usernm6 = v.findViewById(R.id.uptodate);
        usernm1 = v.findViewById(R.id.collection);
        usernm2 = v.findViewById(R.id.interest);
        usernm3 = v.findViewById(R.id.amount2);
        usernm5 = v.findViewById(R.id.status);
        linearonto = v.findViewById(R.id.lon);
        linearupto = v.findViewById(R.id.lupto);
        bankrow = v.findViewById(R.id.bankrow);
        accountrow = v.findViewById(R.id.accountrow);
        ifscrow = v.findViewById(R.id.ifscrow);
        investedamt = v.findViewById(R.id.invested_amount);
        currentamt = v.findViewById(R.id.current_amount);
        current_amt = v.findViewById(R.id.investedamt);
        invested_amt = v.findViewById(R.id.currentamt);
        imageView = v.findViewById(R.id.cancel);



        Bundle margs = getArguments();
        String no = margs.getString("fragacc");
        String fullname = margs.getString("fullname");
        String ifsc = margs.getString("fragifsc");
        String bank = margs.getString("fragbank");
        boolean status = margs.getBoolean("fragstatus");
        String ondate = margs.getString("fragondate");
        String uptodate = margs.getString("fraguptodate");
        String fraginvestedamt = String.valueOf(margs.getInt("fraginvestedamt"));
        String fragcurrentamt = String.valueOf(margs.getInt("fragcurrentamt"));
        String key = margs.getString("key");
        System.out.println(status);
        int laon = margs.getInt("loan");
        if (key.equals("2021")) {
            usernm1.setVisibility(View.VISIBLE);
            usernm2.setVisibility(View.VISIBLE);
            usernm3.setVisibility(View.VISIBLE);
            bankrow.setVisibility(View.VISIBLE);
            accountrow.setVisibility(View.VISIBLE);
            ifscrow.setVisibility(View.VISIBLE);
            invested_amt.setVisibility(View.VISIBLE);
            current_amt.setVisibility(View.VISIBLE);
            investedamt.setText(fraginvestedamt);
            currentamt.setText(fragcurrentamt);
        }else{
            usernm1.setVisibility(View.VISIBLE);
            usernm2.setVisibility(View.VISIBLE);
            usernm3.setVisibility(View.VISIBLE);
            usernm6.setVisibility(View.VISIBLE);
            usernm4.setVisibility(View.VISIBLE);
        }
        if (!status) {
            usernm1.setText("NILL");
            usernm5.setText("OFF");


        } else {
            linearonto.setVisibility(View.VISIBLE);
            linearupto.setVisibility(View.VISIBLE);
            usernm5.setText("ON");
            usernm1.setText(String.valueOf(laon));
            usernm4.setText(ondate);
            usernm6.setText(uptodate);

        }


        textView.setText(fullname);
        usernm.setText(no);
        usernm2.setText(bank);
        usernm3.setText(ifsc);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return v;

    }
}
