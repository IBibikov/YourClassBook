package com.bibikov.yourclassbook.data.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Student;

import java.util.List;

/**
 * Интерфейс для работы с таблицей "student"
 *
 * @author Бибиков Игорь
 */
@Dao
public interface StudentDao {
    /**
     * Вставка сущности "студент" в таблицу
     *
     * @param student {@link Student}
     */
    @Insert
    void insertStudent(Student student);

    /**
     * Запрос на получение студента, с учетом учебной группы
     *
     * @param idOwner {@link Student}
     * @return livedata студентов
     */
    @Query("SELECT * FROM student WHERE groupOwnerID= :idOwner")
    LiveData<List<Student>> getStudensByIdOwner(int idOwner);

    /**
     * Запрос на получение студента, с учетом учебной группы
     *
     * @param idOwner {@link Student}
     * @return лист студентов
     */
    @Query("SELECT * FROM student WHERE groupOwnerID = :idOwner")
    List<Student> getStudentSync(int idOwner);

    /**
     * Запрос на получение всех студентов
     *
     * @return лист студентов
     */
    @Query("SELECT * FROM student")
    List<Student> getStudents();

}
