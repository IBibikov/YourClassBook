package com.bibikov.yourclassbook.domain.repository;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.bibikov.yourclassbook.data.db.AppDataBase;
import com.bibikov.yourclassbook.data.db.GradeDao;
import com.bibikov.yourclassbook.data.db.GroupDao;
import com.bibikov.yourclassbook.data.db.StudentDao;
import com.bibikov.yourclassbook.data.db.TeacherDao;
import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.data.entity.Teacher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SchoolRepositoryTest {

    private TeacherDao teacherDao;
    private GroupDao groupDao;
    private StudentDao studentDao;
    private GradeDao gradeDao;
    private AppDataBase db;
    SchoolRepository schoolRepository;
    private static final int KEY_OF_TABLE = 1;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).allowMainThreadQueries().build();
        teacherDao = db.teacherDao();
        groupDao = db.groupDao();
        studentDao = db.studentDao();
        gradeDao = db.gradeDao();
        schoolRepository=new SchoolRepository(context);
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void insertTeachers() {
        Teacher teacher = new Teacher("Мария", "математика");
        schoolRepository.insertTeacher(teacher);
        List<Teacher> teachers = schoolRepository.getTeacherTest();
        assertEquals(1, teachers.get(0).getTeacherId());
    }

    @Test
    public void insertGroup() {
        Group group = new Group("5g", 1);
        schoolRepository.insertGroup(group);
        List<Group> groups = schoolRepository.getGroupTest();
        assertEquals(1, groups.get(0).getGroupId());
    }

    @Test
    public void insertStudent() {
        Student student = new Student(1, "Петя");
        schoolRepository.insertStudent(student);
        List<Student> students = schoolRepository.getStudentTest();
        assertEquals(1, students.get(0).getStudentId());
    }

    @Test
    public void insertGrade() {
        Grade grade = new Grade("2", 1);
        schoolRepository.insertGrade(grade);
        List<Grade> grades = schoolRepository.getGradeTest();
        assertEquals(1, grades.get(0).getGradeId());
    }


    @Test
    public void getIdAllTeacher() {
        Teacher teacher = new Teacher("Мария", "математика");
        Teacher teacher2 = new Teacher("Анна", "русский");
        schoolRepository.insertTeacher(teacher);
        schoolRepository.insertTeacher(teacher2);
        List<Integer> listId = schoolRepository.getIdAllTeacher();
        assertEquals(1, (int) (listId.get(0)));
        assertEquals(2, (int) (listId.get(1)));
    }

    @Test
    public void getGrade() {
        Grade grade = new Grade("2", 1);
        schoolRepository.insertGrade(grade);
        List<Grade> gradeAfter = schoolRepository.getGrade(1);
        assertEquals(1,gradeAfter.get(0).getGradeId());
    }

    @Test
    public void getStudentSync() {
        Student student = new Student(1, "Никита");
        schoolRepository.insertStudent(student);
        List<Student> studentsAfter = schoolRepository.getStudentSync(1);
        assertEquals(1,studentsAfter.get(0).getStudentId());
    }


    @Test
    public void getmAllGroups() {
        // TODO
    }

    @Test
    public void getStudents() {
        // TODO
    }

    @Test
    public void getAllGrade() {
        // TODO
    }

    @Test
    public void getTeacher() {
        // TODO
    }

}