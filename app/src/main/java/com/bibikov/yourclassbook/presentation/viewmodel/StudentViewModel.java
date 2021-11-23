package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

import java.util.List;
import java.util.Objects;

public class StudentViewModel extends AndroidViewModel {


    private LiveData<List<Student>> mAllStudentsByGroup;
    private LiveData<List<Student>> mAllStydentById;
    public SchoolRepository mSchoolRepository;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository = new SchoolRepository(application);
    }

    public void insertStudent(Student student) {
        mSchoolRepository.insertStudent(student);
    }


    public LiveData<List<Student>> getStudent(int id) {
        mAllStudentsByGroup = mSchoolRepository.getStudents(id);
        return mAllStudentsByGroup;
    }


    public int idOfStudent(int idOfGroup, int position) {
        mAllStydentById = mSchoolRepository.getStudents(idOfGroup);
        return Objects.requireNonNull(mAllStydentById.getValue()).get(position).getStudentId();
    }


    public int idStudent(int idOfGroup, int position) {
        int d = mSchoolRepository.getStudentSync(idOfGroup).get(position).getStudentId();
        return d;
    }
}
