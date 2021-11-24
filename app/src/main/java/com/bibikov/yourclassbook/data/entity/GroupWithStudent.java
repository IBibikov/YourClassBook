package com.bibikov.yourclassbook.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

/**
 * Промежуточная сущность, отражающая связь "один ко многим" для сущностей "группа" и "студент"
 *
 * @author Бибиков Игорь
 */
public class GroupWithStudent {
    @Embedded
    public Group group;
    @Relation(
            parentColumn = "groupId",
            entityColumn = "groupOwnerID"
    )
    List<Student> students;
}
