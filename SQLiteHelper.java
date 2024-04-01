package com.example.courseregistrationwaitinglist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String CREATE_TABLE_COURCE = " create table Cources( Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT NOT NULL,LastName TEXT NOT NULL,CourceName TEXT NOT NULL,CourceCode TEXT NOT NULL,StudentYear TEXT NOT NULL,Priority TEXT NOT NULL, Phone TEXT NOT NULL);";
    public static final String DB_NAME = "Course.DB";
    public static final int DB_VERSION = 1;
    public static final String Id = "id";


    public static final String FirstName = "FirstName";

    public static final String LastName = "LastName";

    public static final String CourseName = "CourseName";

    public static final String CourseCode = "CourseCode";

    public static final String StudentYear = "StudentYear";

    public static final String Priority = "Priority";

    public static final String Phone = "Phone";
    public static final String TABLE_NAME_STUDENT = "Courses";


    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COURCE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Courses");
        onCreate(db);
    }
}