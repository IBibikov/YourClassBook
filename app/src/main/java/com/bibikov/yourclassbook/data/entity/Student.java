package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {
    @PrimaryKey(autoGenerate = true)
    int studentId;
    int groupOwnerID;
    String nameOfStudent;
}
