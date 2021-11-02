package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher")
public class Teacher {
    @PrimaryKey(autoGenerate = true)
    int id_teacher;
    String fio_teacher;
    String subject;
}
