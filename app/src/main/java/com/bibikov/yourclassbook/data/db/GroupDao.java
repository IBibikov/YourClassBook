package com.bibikov.yourclassbook.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Group;

import java.util.List;

/**
 * Интерфейс для работы с таблицей "group"
 *
 * @author Бибиков Игорь
 */
@Dao
public interface GroupDao {
    /**
     * Вставка сущности "группа" в таблицу
     *
     * @param group {@link Group}
     */
    @Insert
    public void insertGroup(Group group);

    /**
     * Запрос на получение всех учебных групп
     *
     * @return livedata всех групп
     */
    @Query("SELECT * FROM `group`")
    public LiveData<List<Group>> getAllGroup();

    /**
     * Запрос на получение всех учебных групп
     *
     * @return лист всех групп
     */
    @Query("SELECT * FROM `group`")
    public List<Group> getGroups();

}
