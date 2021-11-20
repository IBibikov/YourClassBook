package com.bibikov.yourclassbook.domain.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.bibikov.yourclassbook.data.db.AppDataBase;
import com.bibikov.yourclassbook.data.db.GradeDao;
import com.bibikov.yourclassbook.data.db.GroupDao;
import com.bibikov.yourclassbook.data.db.StudentDao;
import com.bibikov.yourclassbook.data.db.TeacherDao;
import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.data.entity.Teacher;

import java.util.List;

public class SchoolRepository {

    private TeacherDao mTeacherDao;
    private GroupDao mGroupDao;
    private StudentDao mStudentDao;
    private GradeDao mGradeDao;
    private LiveData<List<Group>> mAllGroups;

    public SchoolRepository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        mTeacherDao = db.teacherDao();
        mGroupDao = db.groupDao();
        mStudentDao = db.studentDao();
        mGradeDao = db.gradeDao();
        mAllGroups = mGroupDao.getAllGroup();
    }

    public void insertTeacher(Teacher teacher) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mTeacherDao.insertTeacher(teacher);
        });
    }

    public void deleteAllTeacher() {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mTeacherDao.deleteAllTeachers();
        });
    }

    public void deleteAllGroup() {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mGroupDao.deleteAllGroups();
        });
    }

    public void insertGroup(Group group) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mGroupDao.insertGroup(group);
        });
    }

    public void insertStudent(Student student) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mStudentDao.insertStudent(student);
        });
    }

    public List<Integer> getIdAllTeacher() {
        return mTeacherDao.getAllIdOfTeacher();
    }

    public LiveData<List<Group>> getmAllGroups() {
        return mAllGroups;
    }

    public LiveData<List<Student>> getStudents(int idGroup) {
        return mStudentDao.getStudensByIdOwner(idGroup);
    }

    public LiveData<List<Grade>> getAllGrade(int idStudent) {
        return mGradeDao.getGradeByIdOwner(idStudent);
    }

    public void insertGrade(Grade grade) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mGradeDao.insertGrade(grade);
        });
    }
    public List<Student> getStudentSecn(int idGroup) {
        return mStudentDao.getStudentSync(idGroup);
    }

    public LiveData<List<Teacher>> getTeacher(){
        return mTeacherDao.getAllTeachers();
    }

    public List<Grade> getGrade(int idStudent){
        return mGradeDao.getGrade(idStudent);
    }
}
