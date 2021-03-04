package com.dcvg.lab4_androidcb.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dcvg.lab4_androidcb.database.SQLiteHelperManager;
import com.dcvg.lab4_androidcb.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.dcvg.lab4_androidcb.database.SQLiteHelperManager.USER_FULLNAME;
import static com.dcvg.lab4_androidcb.database.SQLiteHelperManager.USER_ID;
import static com.dcvg.lab4_androidcb.database.SQLiteHelperManager.USER_PHONE;
import static com.dcvg.lab4_androidcb.database.SQLiteHelperManager.USER_TABLE;

public class UserDAO {

    private SQLiteHelperManager sqLiteHelperManageStudent;

    public UserDAO(Context context) {
        this.sqLiteHelperManageStudent = new SQLiteHelperManager(context);
    }

    public long insertUser(User user) {
        long result = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_FULLNAME, user.getFullname());
        contentValues.put(USER_PHONE, user.getPhone());
        SQLiteDatabase sqLiteDatabase = sqLiteHelperManageStudent.getWritableDatabase();
        result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.clear();
        String query = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase sqLiteDatabase = sqLiteHelperManageStudent.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    User User = new User(
                            cursor.getString(cursor.getColumnIndex(USER_FULLNAME)),
                            cursor.getString(cursor.getColumnIndex(USER_PHONE)),
                            cursor.getInt(cursor.getColumnIndex(USER_ID))
                    );
                    userList.add(User);
                    cursor.moveToNext();
                }
                cursor.close();
                sqLiteDatabase.close();
            }
        }
        return userList;
    }
}
