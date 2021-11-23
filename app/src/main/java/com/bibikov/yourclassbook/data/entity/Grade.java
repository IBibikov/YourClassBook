package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return gradeId == grade1.gradeId && studentOwner == grade1.studentOwner && Objects.equals(grade, grade1.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, grade, studentOwner);
    }

    public int getGradeId() {
        return gradeId;
    }
}
