package com.bibikov.yourclassbook.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.data.entity.Teacher;

@Database(entities = {Group.class,Grade.class,Student.class, Teacher.class},version = 1)

public abstract class AppDataBase extends RoomDatabase {

    public abstract TeacherDao groupDao();



}
