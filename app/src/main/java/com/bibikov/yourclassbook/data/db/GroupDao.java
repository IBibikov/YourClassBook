package com.bibikov.yourclassbook.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bibikov.yourclassbook.data.entity.Group;

import java.util.List;

@Dao
public interface GroupDao {

    @Insert
    void insertGroup(Group group);

    @Query("DELETE FROM 'group'")
    public void deleteAllGroups();

    @Query("SELECT * FROM `group`")
    LiveData<List<Group>> getAllGroup();


}
