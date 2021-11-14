package com.bibikov.yourclassbook.domain.repository;

import android.app.Application;
import android.content.Context;

import com.bibikov.yourclassbook.data.db.AppDataBase;
import com.bibikov.yourclassbook.data.db.TeacherDao;
import com.bibikov.yourclassbook.data.entity.Teacher;

public class TeacherRepository {

    private TeacherDao mteacherDao;

    public TeacherRepository(Context context) {
        AppDataBase db=AppDataBase.getInstance(context);
        mteacherDao=db.teacherDao();
    }

    public void insert(Teacher teacher){
        AppDataBase.databaseWriteExecutor.execute(()->{
            mteacherDao.insertTeacher(teacher);
        });
    }
}
