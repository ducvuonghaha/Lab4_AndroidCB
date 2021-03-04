package com.dcvg.lab4_androidcb.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelperManager extends SQLiteOpenHelper {

    public static final String DB_NAME = "QUANLYNGUOIDUNG";
    public static final int DB_VERSION = 1;

    public static final String USER_TABLE = "NguoiDung";
    public static final String USER_ID = "IDNguoiDung";
    public static final String USER_FULLNAME = "TenNguoiDung";
    public static final String USER_PHONE = "SDTNguoiDung";

    public SQLiteHelperManager(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLASS_TABLE = "CREATE TABLE " + USER_TABLE + "(" +
                "" + USER_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "" + USER_FULLNAME + " NVARCHAR(100) NOT NULL," +
                "" + USER_PHONE + " NVARCHAR(100) NOT NULL" +
                ")";
        db.execSQL(CREATE_CLASS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
    }
}
