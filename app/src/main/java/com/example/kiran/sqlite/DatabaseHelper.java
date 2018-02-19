package com.example.kiran.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kiran on 11/2/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG ="DatabaseHelper";

    private static final String TABLE_NAME = "peopletable";
    private static final String COL1="ID";
    private static final String COL2="name";


    public DatabaseHelper(Context context){
        super(context, TABLE_NAME , null,1);//passing 1 for error handling

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT)";

        db.execSQL(createTable);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int i1) {

    db.execSQL("DROP IF TABLE EXISTS" + TABLE_NAME);
        onCreate(db);
    }



    public boolean adddata(String item){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues(); //this class is used to store set of values
        contentValues.put(COL2,item);
        Log.d(TAG, "adddata :Adding" + item + "to" + TABLE_NAME);
         long result = db.insert(TABLE_NAME, null ,contentValues);

        //id data inserted correctly it will return true

        if(result == -1){

            return false;}

            else{
                return true;
            }
        }

        public Cursor getdata(){
            //cursor is used for pointing data

            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME;
            Cursor data = db.rawQuery(query,null);
            return data;

        }

    }






























