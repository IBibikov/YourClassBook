package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    int studentId;
    int groupOwnerID;
    int isHere;
    String nameOfStudent;


    public Student(int studentId, int groupOwnerID, int isHere, String nameOfStudent) {
        this.studentId = studentId;
        this.groupOwnerID = groupOwnerID;
        this.isHere = isHere;
        this.nameOfStudent = nameOfStudent;
    }
}
