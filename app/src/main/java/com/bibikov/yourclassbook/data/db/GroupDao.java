package com.bibikov.yourclassbook.data.db;

import androidx.room.Dao;
import androidx.room.Insert;

import com.bibikov.yourclassbook.data.entity.Group;
@Dao
public interface GroupDao {

    @Insert
    void insertGroup(Group group);
}
