package com.example.courseregistrationwaitinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Course_Registration extends AppCompatActivity {

    Button btn;
    EditText first,last,course,code,year,phone;
    CheckBox rbtn;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_registration);


        databaseHelper=new DatabaseHelper(Course_Registration.this);
        btn=findViewById(R.id.reg_btn);

        first=findViewById(R.id.first);
        last=findViewById(R.id.last);
        code=findViewById(R.id.code);
        course=findViewById(R.id.reg_email);
        year=findViewById(R.id.semester);
        phone=findViewById(R.id.phone);

        rbtn=findViewById(R.id.priority);
        getData();
        // creating a new dbhandler class
        // and passing our context to it.
        DBManager  dbManager = new DBManager(Course_Registration.this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName,lastName,courseName,courseCode,studentYear,phoneNumber;
                firstName=first.getText().toString();
                lastName=last.getText().toString();
                courseName=course.getText().toString();
                courseCode=code.getText().toString();
                studentYear=year.getText().toString();
                phoneNumber=phone.getText().toString();
                if(firstName.isEmpty() || lastName.isEmpty() ||
                        courseCode.isEmpty() ||courseName.isEmpty()||
                        studentYear.isEmpty() || phoneNumber.isEmpty()){
                    Toast.makeText(Course_Registration.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    CourseModal courseModal =new CourseModal();
                    courseModal.setFirstName(firstName);
                    courseModal.setLastName(lastName);
                    courseModal.setCourseName(courseName);
                    courseModal.setCourseCode(courseCode);
                    courseModal.setStudentYear(studentYear);
                    courseModal.setPhone(phoneNumber);
                    if(rbtn.isChecked()) {
                        courseModal.setPriority("1");
                        databaseHelper.AddStudnet(courseModal);
                        //dbManager.insert(firstName, lastName, courseName, courseCode, studentYear, "1", phoneNumber);
                        Toast.makeText(Course_Registration.this, "Sucessfully data saved!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Course_Registration.this,MainActivity.class);
                        startActivity(i);
                    }else{
                        courseModal.setPriority("0");
                        databaseHelper.AddStudnet(courseModal);
                        Toast.makeText(Course_Registration.this, "Successfully data saved!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Course_Registration.this,MainActivity.class);
                        startActivity(i);
                    }
                }
            }
        });
    }

    private void getData() {
        try{
            Intent intent = getIntent();
            String FirstName = intent.getStringExtra("FirstName");
            String LastName = intent.getStringExtra("LastName");
            String CourseName = intent.getStringExtra("CourseName");
            String CourseCode = intent.getStringExtra("CourseCode");
            String StudentYear = intent.getStringExtra("StudentYear");
            String Priority = intent.getStringExtra("Priority");
            String Phone = intent.getStringExtra("Phone");

            first.setText(FirstName);
            last.setText(LastName);
            course.setText(CourseName);
            code.setText(CourseCode);
            year.setText(StudentYear);
            phone.setText(Phone);
            if(Priority.equals("1")){
                rbtn.setChecked(true);
            }
        }catch (Exception e){

        }
    }
}