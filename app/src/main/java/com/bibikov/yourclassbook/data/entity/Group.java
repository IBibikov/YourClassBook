package com.bibikov.yourclassbook.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "group")
public class Group {

    @PrimaryKey(autoGenerate = true)
    public int groupId;
    public String nameOfGroup;
    public int teacherOwnerId;

    public Group(String nameOfGroup, int teacherOwnerId) {
        this.nameOfGroup = nameOfGroup;
        this.teacherOwnerId = teacherOwnerId;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public int getGroupId() {
        return groupId;
    }
}
