package com.bibikov.yourclassbook.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;
/**
 * Промежуточная сущность, отражающая связь "один ко многим" для сущностей "студент" и "оценка"
 *
 * @author Бибиков Игорь
 */
public class StudentWithGrade {
    @Embedded
    public Student student;
    @Relation(
            parentColumn = "studentId",
            entityColumn = "studentOwner"
    )
    List<Grade> grades;
}
