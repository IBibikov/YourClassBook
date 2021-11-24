package com.bibikov.yourclassbook.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bibikov.yourclassbook.data.entity.Grade;

import java.util.List;

/**
 * Интерфейс для работы с таблицей "grade"
 *
 * @author Бибиков Игорь
 */
@Dao
public interface GradeDao {
    /**
     * Вставка сущности "оценка" в таблицу
     *
     * @param grade {@link Grade}
     */
    @Insert
    void insertGrade(Grade grade);

    /**
     * Запрос на получение оценки, для выбраного ученика
     *
     * @param idStudentOwner {@link Grade}
     * @return livedata оценок для выбраного ученика
     */
    @Query("SELECT * FROM grade WHERE  studentOwner=:idStudentOwner")
    LiveData<List<Grade>> getGradeByIdOwner(int idStudentOwner);

    /**
     * Запрос на получение оценки, для выбраного ученика
     *
     * @param idStudent {@link Grade}
     * @return лист оценок для выбраного ученика
     */
    @Query("SELECT * FROM grade WHERE  studentOwner=:idStudent")
    List<Grade> getGrade(int idStudent);

    /**
     * Запрос на получение всех оценок
     *
     * @return лист всех оценок
     */
    @Query("SELECT * FROM grade")
    List<Grade> getGrade();
}
