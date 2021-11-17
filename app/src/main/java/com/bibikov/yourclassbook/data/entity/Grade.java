package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "grade")
public class Grade {
    @PrimaryKey(autoGenerate = true)
    int gradeId;
    int grade;
    int studentOwner;


    public Grade(int gradeId, int grade, int studentOwner) {
        this.gradeId = gradeId;
        this.grade = grade;
        this.studentOwner = studentOwner;
    }
}
