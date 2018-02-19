package com.example.kiran.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    DatabaseHelper mdatabasehelper;//referred to DatabaseHelper class we created

    RecyclerView mrecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        ArrayList<String> listdata = intent.getStringArrayListExtra("listdata");

        Toast.makeText(this, "hllo "+listdata.size(), Toast.LENGTH_SHORT).show();

        mdatabasehelper = new  DatabaseHelper(this);

        mrecyclerview = (RecyclerView)findViewById(R.id.programminglist);

        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mrecyclerview.setAdapter(new programmingadapter(listdata));
    }
}
