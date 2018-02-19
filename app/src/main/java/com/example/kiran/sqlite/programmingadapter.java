package com.example.kiran.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kiran on 11/4/17.

 */



public class programmingadapter extends RecyclerView.Adapter<programmingadapter.programmingviewholder> {


    ArrayList<String> data;
    DatabaseHelper mdatabasehelper;


    public programmingadapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public programmingviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_layout, parent, false);//upto here view is created
        return new programmingviewholder(view);
    }

    @Override
    public void onBindViewHolder(programmingviewholder holder, int position) {
        String title = String.valueOf(data.get(position));
        holder.kiran.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public class programmingviewholder extends RecyclerView.ViewHolder {

        TextView kiran;

        public programmingviewholder(View StringView) {
            super(StringView);
            kiran = (TextView) StringView.findViewById(R.id.dbtest);
        }
    }
}