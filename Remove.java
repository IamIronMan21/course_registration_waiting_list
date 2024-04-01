package com.example.courseregistrationwaitinglist;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Remove extends AppCompatActivity {

    ArrayList<CourseModal> studentsList;
    RecyclerView recyclerView;
    MyAdapterRemove adapter;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        DB = new DatabaseHelper(this);
        studentsList = new ArrayList<>();

        recyclerView = findViewById(R.id.remove);
        adapter = new MyAdapterRemove(this, studentsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displayData();
    }

    private void displayData() {
        studentsList.clear(); // Clear the existing list to avoid duplicates
        studentsList.addAll(DB.getAllStudents()); // Get fresh data from the database
        adapter.notifyDataSetChanged(); // Notify the adapter that the dataset has changed
    }

    public void removeStudent(int position) {
        // Remove the student from your dataset or database
        studentsList.remove(position);
        // Notify the adapter that an item has been removed at the specified position
        adapter.notifyItemRemoved(position);
        // Optionally, notify dataset changed to update all items
        // adapter.notifyDataSetChanged();
    }
}
