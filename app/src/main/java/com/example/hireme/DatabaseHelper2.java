package com.example.hireme;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tasker.db";
    public static final String TABLE_NAME = "Taskers";
    //cols
    public static final String COLS_1 = "Name";
    public static final String COLS_2 = "Email";
    public static final String COLS_3 = "Telephone";
    public static final String COLS_4 = "Address";
    public static final String COLS_5 = "Skills";
    public static final String COLS_6 = "Fee";


    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME+ "(Name TEXT, Email TEXT PRIMARY KEY, Telephone TEXT, Address TEXT, Skills TEXT, Fee INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    Cursor readAllData(String location, int skill_set){

        String skill;
        switch (skill_set){
            case 1:skill ="gardening"; break;
            case 2:skill ="cleaning"; break;
            case 3:skill ="shopping and delivery"; break;
            case 4:skill ="handyman"; break;
            default: skill ="gardening";break;


        }
        String query= "SELECT * FROM " + TABLE_NAME + " where Skills like \'" + skill + "\' and Address like \'"+location+"\'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

}
