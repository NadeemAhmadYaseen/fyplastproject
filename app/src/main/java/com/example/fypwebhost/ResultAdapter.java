package com.example.fypwebhost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ResultAdapter extends ArrayAdapter<ResultAdapter> {

    Context context;
    List<ResultAdapter> resultcompare;


    public ResultAdapter(@NonNull Context context, List<ResultAdapter> resultcompare) {
        super(context, R.layout.custom_list_item_result,resultcompare);

        this.context = context;
        this.resultcompare = resultcompare;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item_result,null,true);





        return view;
    }
}
