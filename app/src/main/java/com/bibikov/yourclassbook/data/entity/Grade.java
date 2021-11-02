package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;

import java.util.Date;
@Entity
public class Grade {
    int id_grade;
    int grade;
    Date date;
    int id_teacher;
    int id_student;

}
