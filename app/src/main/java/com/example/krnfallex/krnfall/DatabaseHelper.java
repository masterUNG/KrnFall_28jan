package com.example.krnfallex.krnfall;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NarwhalZ on 29/12/2559.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "database/database.db";
    public static final String TABLE_NAME = "waterfall_info";
    public static final String COL_1 = "waterfall_id";
    public static final String COL_2 = "name_th";
    public static final String COL_3 = "name_eng";
    public static final String COL_4 = "general_th";
    public static final String COL_5 = "general_eng";
    public static final String COL_6 = "history_th";
    public static final String COL_7 = "history_eng";
    public static final String COL_8 = "fee_th";
    public static final String COL_9 = "fee_eng";
    public static final String COL_10 = "travel_th";
    public static final String COL_11 = "travel_eng";
    public static final String COL_12 = "latitude";
    public static final String COL_13 = "longitude";
    public static final String COL_14 = "url360";
    public static final String COL_15 = "video_path";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (WATERFALL_ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME_TH TEXT,NAME_ENG TEXT,GENERAL_TH TEXT,GENERAL_ENG TEXT,HISTORY_TH TEXT,HISTORY_ENG TEXT,FEE_TH TEXT,FEE_ENG TEXT,TRAVEL_TH TEXT,TRAVEL_ENG TEXT,LATITUDE TEXT,LONGITUDE TEXT,URL360 TEXT,ViDEO_PATH TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(db);
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from"+TABLE_NAME,null);
        return res;
    }
}
