package com.example.assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHepler extends SQLiteOpenHelper {
    public DBHepler( Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table user(emailaddress Text primary key, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {

        myDB.execSQL("drop Table if exists user");
    }

    public Boolean insertData(String emailaddress, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("emailaddress", emailaddress);
        contentValues.put("password",password);
        long result = myDB.insert("user",null, contentValues);

        if (result == -1){
            return false;
        }
        else
                return true;

    }

    public Boolean checkusername(String emailaddress){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from user where emailaddress = ?",new String[] {emailaddress});

        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
 public Boolean checkusernamePassword(String emailaddress,String password){
       SQLiteDatabase myDB = this.getWritableDatabase();
       Cursor cursor = myDB.rawQuery("select * from user where emailaddress = ? and password = ?", new String[]{emailaddress,password});
       if (cursor.getCount()>0)
       {
         return true;
       }
       else
       {
           return false;
       }
 }
}
