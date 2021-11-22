package com.bibikov.yourclassbook.domain.repository;

import static org.junit.jupiter.api.Assertions.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import com.bibikov.yourclassbook.data.db.AppDataBase;
import com.bibikov.yourclassbook.data.db.TeacherDao;
import com.bibikov.yourclassbook.data.entity.Teacher;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;



@RunWith(AndroidJUnit4.class)
public class SchoolRepositoryTest {

//    private TeacherDao teacherDao;
//    private AppDataBase db;
//
//    @Before
//    public void createDb(){
//        Context context = ApplicationProvider.getApplicationContext();
//        db = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).allowMainThreadQueries().build();
//        teacherDao=db.teacherDao();
//    }
//
//    @After
//    public void closeDb() throws IOException {
//        db.close();
//    }
//
//
//
//    @Test
//    void insertTeacher() {
//        Teacher teacher= new Teacher("Мария","математика");
//        teacherDao.insertTeacher(teacher);
//        List<Teacher> teachers= teacherDao.getAll();
//        assertEquals(1, teachers.size());
//        assertTrue(teachers.equals(teachers.get(0)));
//    }

    @Test
    void deleteAllTeacher() {
    }

    @Test
    void deleteAllGroup() {
    }

    @Test
    void insertGroup() {
    }

    @Test
    void insertStudent() {
    }

    @Test
    void getIdAllTeacher() {
    }

    @Test
    void getmAllGroups() {
    }

    @Test
    void getStudents() {
    }

    @Test
    void getAllGrade() {
    }

    @Test
    void insertGrade() {
    }

    @Test
    void getStudentSecn() {
    }

    @Test
    void getTeacher() {
    }

    @Test
    void getGrade() {
    }
}