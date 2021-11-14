package com.bibikov.yourclassbook.data.db;

import com.bibikov.yourclassbook.data.entity.*;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bibikov.yourclassbook.data.entity.Group;

import java.util.List;

@Dao
public interface TeacherDao {
    @Insert
    void insertTeacher(Teacher teacher);

    @Query("DELETE FROM teacher")
    public void deleteAllTeachers();
}
