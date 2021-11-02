package com.bibikov.yourclassbook.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "group")
public class Group {
    @PrimaryKey(autoGenerate = true)
    int id_group;
    String name_group;
}
