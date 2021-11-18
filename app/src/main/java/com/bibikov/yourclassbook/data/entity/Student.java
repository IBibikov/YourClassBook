package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    public int studentId;
    public int groupOwnerID;
    public String nameOfStudent;


    public Student(int groupOwnerID, String nameOfStudent) {
        this.groupOwnerID = groupOwnerID;
        this.nameOfStudent = nameOfStudent;
    }

    public int getGroupOwnerID() {
        return groupOwnerID;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }
}
