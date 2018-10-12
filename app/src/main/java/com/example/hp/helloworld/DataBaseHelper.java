package com.example.hp.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="Student.db";
    public static final String TABLE_NAME="Student.table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="SURNAME";
    public static final String COL_4="MARKS";

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase dp) {
        dp.execSQL("CREATE TABLE Student_table" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int olderVersion, int newVersion) {
        dp.execSQL("DROP TABLE IF EXISTS Student_table");

    }

    public  Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("Select * from Student_table",null);
        return res;
    }
    public boolean insertData(String name,String surname,String marks){
        SQLiteDatabase dp=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result=dp.insert("Student_table",null,contentValues);
        dp.close();
        if (result == -1) {
            return false;
        }
        else
        {
            return true;
        }
    }


}
