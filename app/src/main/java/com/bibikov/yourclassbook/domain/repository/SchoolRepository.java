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
    /**
     * Реализация паттерна "репозиторий" для доступа к запросам, которые хранятся в интерфейсах Dao
     *
     * @author Бибиков Игорь
     */
    private TeacherDao mTeacherDao;
    private GroupDao mGroupDao;
    private StudentDao mStudentDao;
    private GradeDao mGradeDao;
    private LiveData<List<Group>> mAllGroups;

    /**
     * Конструктор
     * mTeacherDao для работы с сущностью "учитель"
     * mGroupDao для работы с сущностью "группа"
     * mStudentDao для работы с сущностью "студент"
     * mGradeDao для работы с сущностью "оценка"
     * mAllGroups список всех групп
     */
    public SchoolRepository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        mTeacherDao = db.teacherDao();
        mGroupDao = db.groupDao();
        mStudentDao = db.studentDao();
        mGradeDao = db.gradeDao();
        mAllGroups = mGroupDao.getAllGroup();
    }

    /**
     * Метод асинхронной вставки сущности "учитель" в соответствующую таблицу
     *
     * @param teacher
     */
    public void insertTeacher(Teacher teacher) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mTeacherDao.insertTeacher(teacher);
        });
    }

    /**
     * Метод асинхронной вставки сущности "группа" в соответствующую таблицу
     *
     * @param group
     */
    public void insertGroup(Group group) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mGroupDao.insertGroup(group);
        });
    }

    /**
     * Метод асинхронной вставки сущности "студент" в соответствующую таблицу
     *
     * @param student
     */
    public void insertStudent(Student student) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mStudentDao.insertStudent(student);
        });
    }

    /**
     * Метод для получения id всех учителей
     *
     * @return лист id учителей
     */
    public List<Integer> getIdAllTeacher() {
        return mTeacherDao.getAllIdOfTeacher();
    }

    /**
     * Метод для получения всех групп
     *
     * @return livedata со всеми группами
     */
    public LiveData<List<Group>> getmAllGroups() {
        return mAllGroups;
    }

    /**
     * Метод для получения всех студентов в зависимости от группы
     *
     * @return livedata со всеми студентами в заданной группе
     */
    public LiveData<List<Student>> getStudents(int idGroup) {
        return mStudentDao.getStudensByIdOwner(idGroup);
    }

    /**
     * Метод для получения оценок заданного студента
     *
     * @return livedata со всеми оценками студента
     */
    public LiveData<List<Grade>> getAllGrade(int idStudent) {
        return mGradeDao.getGradeByIdOwner(idStudent);
    }

    /**
     * Метод асинхронной вставки сущности "оценка" в соответствующую таблицу
     *
     * @param grade
     */
    public void insertGrade(Grade grade) {
        AppDataBase.databaseWriteExecutor.execute(() -> {
            mGradeDao.insertGrade(grade);
        });
    }

    /**
     * Метод получения студента по группе (синхронно)
     *
     * @param idGroup
     * @return лист студентов в заданной группе
     */
    public List<Student> getStudentSync(int idGroup) {
        return mStudentDao.getStudentSync(idGroup);
    }

    /**
     * Метод получения всех учителйе
     *
     * @return livedata со всеми учителями
     */
    public LiveData<List<Teacher>> getTeacher() {
        return mTeacherDao.getAllTeachers();
    }

    /**
     * Метод получения всех оценок для заданного студента
     *
     * @param idStudent
     * @return лист всех оценок для студента
     */
    public List<Grade> getGrade(int idStudent) {
        return mGradeDao.getGrade(idStudent);
    }

    /**
     * Метод для написания тестов
     */
    public List<Group> getGroupTest() {
        return mGroupDao.getGroups();
    }

    /**
     * Метод для написания тестов
     */
    public List<Teacher> getTeacherTest() {
        return mTeacherDao.getTeacher();
    }

    /**
     * Метод для написания тестов
     */
    public List<Student> getStudentTest() {
        return mStudentDao.getStudents();
    }

    /**
     * Метод для написания тестов
     */
    public List<Grade> getGradeTest() {
        return mGradeDao.getGrade();
    }

}
