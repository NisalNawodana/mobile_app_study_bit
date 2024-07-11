package com.example.assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBAdmin  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "courseadmin.db";
    private static final String TABLE_NAME = "course_details";

    private static final String COL_1= "COURSE_NAME";
    private static final String COL_2 = "COURSE_FEE";
    private static final String COL_3 = "BRANCH_NAME";
    private static final String COL_4 = "DURATION";
    private static final String COL_5 = "PUBLISHED_ON";
    private static final String COL_6 = "CLOSE_ON";
    private static final String COL_7 = "STARTING_ON";







    public DBAdmin(@Nullable Context context) {
        super(context, DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table  " + TABLE_NAME +"(COURSE_NAME TEXT PRIMARY KEY, COURSE_FEE TEXT, BRANCH_NAME TEXT, DURATION TEXT, PUBLISHED_ON TEXT, CLOSE_ON TEXT, STARTING_ON TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
     onCreate(db);

    }

    public boolean insertData(String admincourse_name, String admincourse_fee, String admincourse_branch,String admincourse_duration, String adminpublished_on, String adminregistration_close, String adminstarting_on )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,admincourse_name);
        contentValues.put(COL_2,admincourse_fee);
        contentValues.put(COL_3,admincourse_branch);
        contentValues.put(COL_4,admincourse_duration);
        contentValues.put(COL_5,adminpublished_on);
        contentValues.put(COL_6,adminregistration_close);
        contentValues.put(COL_7,adminstarting_on);

        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1)
        {return false;}
        else
        { return true;}

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;


    }
    public boolean updateData (String admincourse_name, String admincourse_fee, String admincourse_branch, String admincourse_duration, String adminpublished_on, String adminregistration_close, String adminstarting_on )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,admincourse_name);
        contentValues.put(COL_2,admincourse_fee);
        contentValues.put(COL_3,admincourse_branch);
        contentValues.put(COL_4,admincourse_duration);
        contentValues.put(COL_5,adminpublished_on);
        contentValues.put(COL_6,adminregistration_close);
        contentValues.put(COL_7,adminstarting_on);
        db.update(TABLE_NAME, contentValues,"COURSE_NAME = ?",new String[] {admincourse_name} );
        return true;
    }

public Integer deleteData (String admincourse_name){
    SQLiteDatabase db = this.getWritableDatabase();
    return db.delete(TABLE_NAME,"COURSE_NAME = ?",new String[] {admincourse_name});
}


}
