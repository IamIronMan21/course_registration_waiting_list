package com.example.courseregistrationwaitinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String  DATABASE_NAME="cource_db";
    private static final String TABLE_NAME="cource";
    private static final String ID="id";
    private static final String FirstName="FirstName";
    private static final String LastName="LastName";
    private static final String CourseName="CourseName";
    private static final String CourseCode="CourseCode";
    private static final String StudentYear="StudentYear";
    private static final String Priority="Priority";
    private static final String Phone="phone";


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_query="CREATE TABLE if not EXISTS "+TABLE_NAME+
                "("+
                ID+" INTEGER PRIMARY KEY,"+
                FirstName+" TEXT ,"+
                LastName+" TEXT ,"+
                CourseName+ " TEXT ,"+
                CourseCode+ " TEXT ,"+
                StudentYear+" TEXT ,"+
                Priority+" TEXT ,"+
                Phone+ " TEXT "+
                ")";
        db.execSQL(table_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public void AddStudnet(CourseModal model){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(FirstName,model.getFirstName());
        contentValues.put(LastName,model.getLastName());
        contentValues.put(CourseName,model.getCourseName());
        contentValues.put(CourseCode,model.getCourseCode());
        contentValues.put(StudentYear,model.getStudentYear());
        contentValues.put(Priority,model.getPriority());
        contentValues.put(Phone,model.getPhone());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public CourseModal getStudent(String id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{ID,FirstName,LastName,CourseName,CourseCode,StudentYear,Priority,Phone},FirstName+" = ?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        CourseModal model=new CourseModal(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
        db.close();
        return model;
    }

    public List<CourseModal> getAllStudents(){
        List<CourseModal> studentModelList=new ArrayList<>();
        String query="SELECT * from "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                CourseModal studentModel=new CourseModal(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(4),cursor.getString(3),cursor.getString(5),cursor.getString(6),cursor.getString(7));
                studentModelList.add(studentModel);
            }
            while (cursor.moveToNext());

        }
        db.close();
        return studentModelList;
    }

    public int updateStudent(CourseModal studentModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(FirstName,studentModel.getFirstName());
        contentValues.put(LastName,studentModel.getLastName());
        contentValues.put(CourseName,studentModel.getCourseName());
        contentValues.put(CourseCode,studentModel.getCourseCode());
        contentValues.put(StudentYear,studentModel.getStudentYear());
        contentValues.put(Priority,studentModel.getPriority());
        contentValues.put(Phone,studentModel.getPhone());
        return db.update(TABLE_NAME,contentValues,ID+"=?",new String[]{String.valueOf(studentModel.getId())});

    }

    public Cursor getdata(){
        SQLiteDatabase Db = this.getWritableDatabase();
        Cursor cursor = Db.rawQuery("Select * from cource",null);
        return  cursor;
    }
    public void deleteStudent(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,FirstName+"=?",new String[]{id});
        db.close();
    }

    public int getTotalCount(){
        String query="SELECT * from "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }
}
