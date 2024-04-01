package com.example.courseregistrationwaitinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Priority extends AppCompatActivity {

    ArrayList<CourseModal> contacts;
    RecyclerView recyclerView;
    ArrayList<String> FirstName, LastName, CourseName, CourseCode, StudentYear, Priority, Phone, message_button;
    DatabaseHelper DB;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority);
        DB = new DatabaseHelper(this);
        FirstName = new ArrayList<>();
        LastName = new ArrayList<>();
        CourseName = new ArrayList<>();
        CourseCode = new ArrayList<>();
        StudentYear = new ArrayList<>();
        Priority = new ArrayList<>();
        Phone = new ArrayList<>();
        message_button = new ArrayList<>();

        recyclerView = findViewById(R.id.proirity);
        adapter = new MyAdapter(this, FirstName, LastName, CourseName, CourseCode, StudentYear, Priority, Phone);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
//        List<CourseModal> modalList = DB.getAllStudents();
//        //Toast.makeText(this, ""+modalList.size(), Toast.LENGTH_SHORT).show();
//        for (CourseModal temp : modalList) {
//            FirstName.add(temp.FirstName);
//
//            Toast.makeText(this, ""+temp.Priority, Toast.LENGTH_SHORT).show();
////            CourseCode.add(temp.CourseCode);
//        }
//        FirstName.add(modalList);
        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                if(cursor.getString(6).toString().equals("1")) {
                    FirstName.add(cursor.getString(1));
                    Phone.add(cursor.getString(3));
                }
            }
        }
    }
}