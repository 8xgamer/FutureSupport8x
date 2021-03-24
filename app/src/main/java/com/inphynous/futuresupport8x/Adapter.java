package com.inphynous.futuresupport8x;

import android.content.Context;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<LoanClass> userList;
    private LayoutInflater layoutInflater;
    public Adapter(List<LoanClass> List,Context context){

        this.layoutInflater = LayoutInflater.from(context);
        this.userList=List;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int textview1 = userList.get(position).getSr_no();
        String textview2 = userList.get(position).getName();
        int textview3 = userList.get(position).getLoan_amt();
        String textview4 = userList.get(position).getDate_of_sanction();
        String textview5 = userList.get(position).getNo_on_month();
        String textview6 = userList.get(position).getStatus_loan();

        holder.setData(textview1,textview2,textview3,textview4,textview5,textview6);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView sr_no;
        private final TextView name, amount_loan;
        private final TextView date_of_loan;
        private final TextView Month_in_no,status_of_loan;

        public ViewHolder(View itemView){
            super(itemView);
            sr_no=itemView.findViewById(R.id.srno);
            System.out.println(sr_no);
            name=itemView.findViewById(R.id.name);
            amount_loan=itemView.findViewById(R.id.amt);
            date_of_loan=itemView.findViewById(R.id.date);
            Month_in_no=itemView.findViewById(R.id.no_of_month);
            status_of_loan = itemView.findViewById(R.id.status);
        }

        public void setData(int textview1, String textview2, int textview3, String textview4, String textview5, String textview6) {
            sr_no.setText(String.valueOf(textview1));
            System.out.println(sr_no);
            name.setText(textview2);
            amount_loan.setText(String.valueOf(textview3));
            date_of_loan.setText(textview4);
            Month_in_no.setText(textview5);
            status_of_loan.setText(String.valueOf(textview6));


        }
    }
}
