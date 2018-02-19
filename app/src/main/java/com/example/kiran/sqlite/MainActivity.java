package com.example.kiran.sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mdatabasehelper;//referred to DatabaseHelper class we created
    EditText medittext;
    Button madd,mview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        medittext = (EditText)findViewById(R.id.editText);
        madd = (Button)findViewById(R.id.btnadd);
        mview = (Button)findViewById(R.id.btnview);
       mdatabasehelper = new  DatabaseHelper(this);
        //rrr = (RelativeLayout) findViewById(R.id.relativelayout1);

        Cursor data= mdatabasehelper.getdata();
        final ArrayList<String> listdata = new ArrayList<>();
        while (data.moveToNext()){
            listdata.add(data.getString(1));
            Log.d("ade", String.valueOf(listdata.size()));
        }


       madd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newentry = medittext.getText().toString();//medittext refer to out xml edittext
                if(medittext.length()!=0){//to check if we  enter anything on textfield or not..if not empty add on database
                    Adddata(newentry);

                    medittext.setText("");//to reset the text
                }

                else{
                    toastmessage("you have to enter something on text field");

                    }
                }
        });

       mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putStringArrayListExtra("listdata",listdata);
                startActivity(intent);
            }
        });

    }


    public  void  Adddata(String newentry) {
        //boolean is used as adddata class is of boolean in DatabaseHelper
        boolean insertdata = mdatabasehelper.adddata(newentry);//here addaata is from DatabaseHelper class which we excess from mdatabasehelper
        if (insertdata) {
            toastmessage("data successfully inserted");
        } else {
            toastmessage("something went wrong");
        }
    }

    public  void toastmessage(String message){

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();


    }


}
