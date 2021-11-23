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
    public void insertGroup(Group group);

    @Query("SELECT * FROM `group`")
    public LiveData<List<Group>> getAllGroup();

    @Query("SELECT * FROM `group`")
    public List<Group> getGroups();

}
