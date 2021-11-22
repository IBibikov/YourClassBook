package com.bibikov.yourclassbook.domain.repository;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.bibikov.yourclassbook.data.db.AppDataBase;
import com.bibikov.yourclassbook.data.db.GradeDao;
import com.bibikov.yourclassbook.data.db.GroupDao;
import com.bibikov.yourclassbook.data.db.StudentDao;
import com.bibikov.yourclassbook.data.db.TeacherDao;
import com.bibikov.yourclassbook.data.entity.Teacher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

public class SchoolRepositoryTest {

    private TeacherDao teacherDao;
    private GroupDao groupDao;
    private StudentDao studentDao;
    private GradeDao gradeDao;
    private AppDataBase db;

    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).allowMainThreadQueries().build();
        teacherDao=db.teacherDao();
        groupDao=db.groupDao();
        studentDao=db.studentDao();
        gradeDao=db.gradeDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void insertTeachers() {
        Teacher teacher= new Teacher("Мария","математика");
        teacherDao.insertTeacher(teacher);
        List<Teacher> teachers= teacherDao.getAll();
        assertEquals(1, teachers.size());
    }

    @Test
    public void insertGroup() {
    }

    @Test
    public void insertStudent() {
    }
    @Test
    public void insertGrade() {
    }

    @Test
    public void deleteAllTeacher() {
    }

    @Test
    public void deleteAllGroup() {
    }

    @Test
    public void getIdAllTeacher() {
    }

    @Test
    public void getmAllGroups() {
    }

    @Test
    public void getStudents() {
    }

    @Test
    public void getAllGrade() {
    }



    @Test
    public void getStudentSecn() {
    }

    @Test
    public void getTeacher() {
    }

    @Test
    public void getGrade() {
    }
}