package com.example.courseregistrationwaitinglist;

import java.util.ArrayList;

public class CourseModal {
    String Id="";
    String FirstName="";
    String LastName="";
    String CourseName="";
    String CourseCode="";
    String StudentYear="";
    String Priority="";
    String Phone="";

    public CourseModal(String id, String firstName, String lastName, String courseName, String courseCode, String studentYear, String priority, String phone) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        CourseName = courseName;
        CourseCode = courseCode;
        StudentYear = studentYear;
        Priority = priority;
        Phone = phone;
    }
    public CourseModal(){

    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public String getStudentYear() {
        return StudentYear;
    }

    public void setStudentYear(String studentYear) {
        StudentYear = studentYear;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
    private static int lastContactId = 0;

    public static ArrayList<CourseModal> createContactsList(int numContacts) {
        ArrayList<CourseModal> contacts = new ArrayList<CourseModal>();

        for (int i = 1; i <= numContacts; i++) {
            // contacts.add(new CourseModal("Person " + lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
