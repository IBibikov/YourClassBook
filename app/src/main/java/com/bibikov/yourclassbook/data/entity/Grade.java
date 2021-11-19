package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "grade")
public class Grade {
    @PrimaryKey(autoGenerate = true)
    public int gradeId;
    public String grade;
    public int studentOwner;


    public Grade(String grade, int studentOwner) {
        this.grade = grade;
        this.studentOwner = studentOwner;
    }


    public String getGrade() {
        return grade;
    }

    public int getStudentOwner() {
        return studentOwner;
    }
}
