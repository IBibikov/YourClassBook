package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    int studentId;
    int groupOwnerID;
    String nameOfStudent;


    public Student(int groupOwnerID, String nameOfStudent) {
        this.groupOwnerID = groupOwnerID;
        this.nameOfStudent = nameOfStudent;
    }
}
