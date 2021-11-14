package com.bibikov.yourclassbook.domain.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.bibikov.yourclassbook.data.db.AppDataBase;
import com.bibikov.yourclassbook.data.db.GroupDao;
import com.bibikov.yourclassbook.data.db.TeacherDao;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Teacher;

import java.util.List;

import io.reactivex.Flowable;

public class SchoolRepository {

    private TeacherDao mTeacherDao;
    private GroupDao mGroupDao;


    public SchoolRepository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        mTeacherDao = db.teacherDao();
        mGroupDao = db.groupDao();
    }

    public void insert(Teacher teacher) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mTeacherDao.insertTeacher(teacher);
        });
    }

    public void deleteAllTeacher() {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mTeacherDao.deleteAllTeachers();
        });
    }

    public void insertGroup(Group group) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mGroupDao.insertGroup(group);
        });
    }

    public Flowable<List<Integer>> getIdTeacher(){
        return mTeacherDao.getAllIdOfTeacher();
    }
}
