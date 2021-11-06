package com.bibikov.yourclassbook.data.db;
import com.bibikov.yourclassbook.data.entity.*;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bibikov.yourclassbook.data.entity.Group;

import java.util.List;

@Dao
public interface SchoolDao {

    @Insert
    void insertGroup(Group... groups);

    @Delete
    void delete(Group group);

}
