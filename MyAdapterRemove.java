package com.example.courseregistrationwaitinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterRemove extends RecyclerView.Adapter<MyAdapterRemove.MyViewHolder> {
    private Context context;
    private ArrayList<CourseModal> studentsList;

    public MyAdapterRemove(Context context, ArrayList<CourseModal> studentsList) {
        this.context = context;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_remove, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CourseModal student = studentsList.get(position);
        holder.firstName.setText("Student Name: " + student.getFirstName());
        holder.courseName.setText("Course Name: " + student.getCourseName());

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the removeStudent method of the activity
                ((Remove) context).removeStudent(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, courseName;
        Button removeButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.contact_name);
            courseName = itemView.findViewById(R.id.course_name);
            removeButton = itemView.findViewById(R.id.remove_button);
        }
    }
}
