package com.example.courseregistrationwaitinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private Context context;
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    public DBManager(Context c) {
        this.context = c;
    }
    public DBManager open() throws SQLException {
        this.dbHelper = new SQLiteHelper(this.context);
        this.database = this.dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.dbHelper.close();
    }

    public void insert(String fname, String lname,String cname,String cCode,String syear,String priority,String phone) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(SQLiteHelper.FirstName, fname);
        contentValue.put(SQLiteHelper.LastName, lname);
        contentValue.put(SQLiteHelper.CourseName, cname);
        contentValue.put(SQLiteHelper.CourseCode, cCode);
        contentValue.put(SQLiteHelper.StudentYear, syear);
        contentValue.put(SQLiteHelper.Priority, priority);
        contentValue.put(SQLiteHelper.Phone, phone);
        this.database.insert(SQLiteHelper.TABLE_NAME_STUDENT, null, contentValue);
    }
    public Cursor fetch() {
        Cursor cursor = this.database.query(SQLiteHelper.TABLE_NAME_STUDENT, new String[]{SQLiteHelper.Id, SQLiteHelper.FirstName, SQLiteHelper.LastName,SQLiteHelper.CourseName,SQLiteHelper.CourseCode,SQLiteHelper.StudentYear,SQLiteHelper.Priority,SQLiteHelper.Phone}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public int update(long id,String fname, String lname,String cname,String cCode,String syear,String priority,String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.FirstName, fname);
        contentValues.put(SQLiteHelper.LastName, lname);
        contentValues.put(SQLiteHelper.CourseName, cname);
        contentValues.put(SQLiteHelper.CourseCode, cCode);
        contentValues.put(SQLiteHelper.StudentYear, syear);
        contentValues.put(SQLiteHelper.Priority, priority);
        contentValues.put(SQLiteHelper.Phone, phone);
        return this.database.update(SQLiteHelper.TABLE_NAME_STUDENT, contentValues, "Id = " + id, null);
    }

    public void delete(long _id) {
        this.database.delete(SQLiteHelper.TABLE_NAME_STUDENT, "Id=" + _id, null);
    }
}