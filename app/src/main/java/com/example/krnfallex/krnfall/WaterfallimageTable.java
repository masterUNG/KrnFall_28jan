package com.example.krnfallex.krnfall;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Blob;

/**
 * Created by NarwhalZ on 21/1/2560.
 */
public class WaterfallimageTable {

    private MyDatabase myDatabase;
    private SQLiteDatabase writeSQLite, readSQLite;

    public static final String waterfall_image = "waterfall_image";
    public static final String image_id = "image_id";
    public static final String waterfall_id = "waterfall_id";
    public static final String image_path = "image_path";

    public WaterfallimageTable(Context context) {
        myDatabase = new MyDatabase(context);
        writeSQLite = myDatabase.getWritableDatabase();
        readSQLite = myDatabase.getReadableDatabase();
    }

    public long addNewValueToSQLite(int int_idwimage, int int_waterfallid, Byte[] Bb_imagepath) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(image_id, int_idwimage);
        contentValues.put(waterfall_id, int_waterfallid);
       // contentValues.put(image_path, Bb_imagepath);
        long waterfallimage_Table_id = writeSQLite.insert(waterfall_image, null, contentValues);
        return waterfallimage_Table_id;
    }

}
