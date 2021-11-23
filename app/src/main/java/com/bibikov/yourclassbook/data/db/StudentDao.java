package com.bibikov.yourclassbook.data.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bibikov.yourclassbook.data.entity.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student student);

    @Query("SELECT * FROM student WHERE groupOwnerID= :idOwner")
    LiveData<List<Student>> getStudensByIdOwner(int idOwner);

    @Query("SELECT * FROM student WHERE groupOwnerID = :idOwner")
    List<Student> getStudentSync(int idOwner);

    @Query("SELECT * FROM student")
    List<Student> getStudents();

}
