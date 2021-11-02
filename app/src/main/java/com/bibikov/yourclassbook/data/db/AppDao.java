package com.bibikov.yourclassbook.data.db;

import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.bibikov.yourclassbook.data.entity.Group;

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addGroup(Group... groups);

}
