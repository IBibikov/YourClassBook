package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class Grade {
    @PrimaryKey(autoGenerate = true)
    int gradeId;
    int grade;
    int studentOwner;
}
