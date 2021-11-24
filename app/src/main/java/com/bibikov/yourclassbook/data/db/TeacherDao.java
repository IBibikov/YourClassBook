package com.bibikov.yourclassbook.data.db;

import com.bibikov.yourclassbook.data.entity.*;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bibikov.yourclassbook.data.entity.Group;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Интерфейс для работы с таблицей "teacher"
 *
 * @author Бибиков Игорь
 */
@Dao
public interface TeacherDao {
    /**
     * Вставка сущности "учитель" в таблицу
     *
     * @param teacher {@link Teacher}
     */
    @Insert
    public void insertTeacher(Teacher teacher);

    /**
     * Запрос на получение id всех учителе
     *
     * @return лист id всех учителей
     */
    @Query("SELECT teacherId FROM teacher")
    public List<Integer> getAllIdOfTeacher();

    /**
     * Запрос на получение всех учителей
     *
     * @return livedata со всеми учителями
     */
    @Query("SELECT * FROM teacher")
    public LiveData<List<Teacher>> getAllTeachers();

    /**
     * Запрос на получение всех учителей
     *
     * @return лист со всеми учителями
     */
    @Query("SELECT * FROM teacher")
    public List<Teacher> getTeacher();

}
