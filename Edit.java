package com.example.courseregistrationwaitinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {

    ArrayList<CourseModal> contacts;
    RecyclerView recyclerView;
    ArrayList<String> FirstName, LastName, CourseName, CourseCode, StudentYear, Priority, Phone, message_button;
    DatabaseHelper DB;
    MyAdapterEdit adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        DB = new DatabaseHelper(this);
        FirstName = new ArrayList<>();
        LastName = new ArrayList<>();
        CourseName = new ArrayList<>();
        CourseCode = new ArrayList<>();
        StudentYear = new ArrayList<>();
        Priority = new ArrayList<>();
        Phone = new ArrayList<>();
        message_button = new ArrayList<>();

        recyclerView = findViewById(R.id.edit);
        adapter = new MyAdapterEdit(this, FirstName, LastName, CourseName, CourseCode, StudentYear, Priority, Phone);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                FirstName.add(cursor.getString(1));
                Phone.add(cursor.getString(3));
            }
        }
    }
}