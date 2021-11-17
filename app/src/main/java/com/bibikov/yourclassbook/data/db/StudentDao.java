package com.bibikov.yourclassbook.data.db;


import androidx.room.Dao;
import androidx.room.Insert;

import com.bibikov.yourclassbook.data.entity.Student;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student student);

}
