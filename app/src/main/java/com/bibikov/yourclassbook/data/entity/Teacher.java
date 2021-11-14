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


    public Teacher( String fio_teacher, String subject) {
        this.fio_teacher = fio_teacher;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }
}
