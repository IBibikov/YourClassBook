package com.bibikov.yourclassbook.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

public class TeacherAndGroup {
    @Embedded public Teacher teacher;
    @Relation(
            parentColumn = "teacherId",
            entityColumn = "teacherOwnerId"
    )
    public Group group;
}
