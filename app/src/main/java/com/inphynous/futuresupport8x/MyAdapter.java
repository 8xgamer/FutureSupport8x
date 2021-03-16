package com.inphynous.futuresupport8x;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Employee> {
    Context context;
    List<Employee> arrayListEmployee;
    int i = 0;

    public MyAdapter(@NonNull Context context, List<Employee> arrayListEmployee) {
        super(context, R.layout.custom_list_item, arrayListEmployee);
        this.context = context;
        this.arrayListEmployee = arrayListEmployee;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, null, true);
        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);
        GradientDrawable gradientDrawable = (GradientDrawable) tvID.getBackground().mutate();

        tvID.setText(String.valueOf(position + 1));
        tvName.setText(arrayListEmployee.get(position).getFullname());
        if (arrayListEmployee.get(position).isStatus()) {
            gradientDrawable.setColor(Color.RED);
        } else {
            gradientDrawable.setColor(R.color.green);
        }

        return view;
    }
}
