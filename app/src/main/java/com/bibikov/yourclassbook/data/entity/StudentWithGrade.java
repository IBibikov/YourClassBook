package com.bibikov.yourclassbook.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class StudentWithGrade {
    @Embedded
    public Student student;
    @Relation(
            parentColumn = "studentId",
            entityColumn = "studentOwner"
    )
    List<Grade> grades;
}
