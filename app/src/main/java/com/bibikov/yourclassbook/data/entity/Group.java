package com.bibikov.yourclassbook.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "group")
public class Group {

    @PrimaryKey(autoGenerate = true)
    int groupId;
    public String nameOfGroup;
    public int teacherOwnerId;

}
