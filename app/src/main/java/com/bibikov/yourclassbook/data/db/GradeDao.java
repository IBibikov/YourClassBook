package com.bibikov.yourclassbook.data.db;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bibikov.yourclassbook.data.entity.Grade;

import java.util.List;


@Dao
public interface GradeDao {
    @Insert
    void insertGrade(Grade grade);

    @Query("SELECT * FROM grade WHERE  studentOwner=:idStudentOwner")
    LiveData<List<Grade>> getGradeByIdOwner(int idStudentOwner);

    @Query("SELECT * FROM grade WHERE  studentOwner=:idStudent")
    List<Grade> getGrade (int idStudent);

    @Query("SELECT * FROM grade")
    List<Grade> getGrade();
}
