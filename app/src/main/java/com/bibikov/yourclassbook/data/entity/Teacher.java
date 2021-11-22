package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(fio_teacher, teacher.fio_teacher) && Objects.equals(subject, teacher.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio_teacher, subject);
    }
}
