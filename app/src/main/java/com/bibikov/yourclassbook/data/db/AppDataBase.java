package com.bibikov.yourclassbook.data.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.data.entity.Teacher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Реализация RoomDatabase для приложения
 *
 * @author Бибиков Игорь
 */
@Database(entities = {Group.class, Grade.class, Student.class, Teacher.class}, version =1)

public abstract class AppDataBase extends RoomDatabase {
    /**
     * Получение Dao для работы с таболицой "teacher"
     */
    public abstract TeacherDao teacherDao();
    /**
     * Получение Dao для работы с таболицой "group"
     */
    public abstract GroupDao groupDao();
    /**
     * Получение Dao для работы с таболицой "student"
     */
    public abstract StudentDao studentDao();
    /**
     * Получение Dao для работы с таболицой "grade"
     */
    public abstract GradeDao gradeDao();

    private static volatile AppDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    /**
     * Получение экземпляра базы данных
     *  @return {@link AppDataBase}
     */
    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "Sample.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
