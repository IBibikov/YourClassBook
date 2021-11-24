package com.bibikov.yourclassbook.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

/**
 * Промежуточная сущность, отражающая связь "один ко многим" для сущностей "учитель" и "группа"
 *
 * @author Бибиков Игорь
 */
public class TeacherAndGroup {
    @Embedded
    public Teacher teacher;
    @Relation(
            parentColumn = "teacherId",
            entityColumn = "teacherOwnerId"
    )
    public Group group;
}
