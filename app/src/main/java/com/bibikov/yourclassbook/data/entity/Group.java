package com.bibikov.yourclassbook.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "group")
public class Group {

    @PrimaryKey(autoGenerate = true)
    int groupId;
    public String nameOfGroup;
    public int teacherOwnerId;

    @Ignore
    public Group(int groupId, String nameOfGroup, int teacherOwnerId) {
        this.groupId = groupId;
        this.nameOfGroup = nameOfGroup;
        this.teacherOwnerId = teacherOwnerId;
    }
}
