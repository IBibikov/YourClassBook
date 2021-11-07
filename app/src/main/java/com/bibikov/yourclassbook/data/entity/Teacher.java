package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher")
public class Teacher {
    @PrimaryKey(autoGenerate = true)
    public int teacherId;
    public String fio_teacher;
    public String subject;

    @Ignore
    public Teacher(int teacherId, String fio_teacher, String subject) {
        this.teacherId = teacherId;
        this.fio_teacher = fio_teacher;
        this.subject = subject;
    }
}
