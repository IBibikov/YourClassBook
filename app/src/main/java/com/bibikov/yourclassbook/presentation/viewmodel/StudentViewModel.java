package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {


    private LiveData<List<Student>> mAllStudentsByGroup;
    public SchoolRepository mSchoolRepository;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository=new SchoolRepository(application);
    }
    public void insertStudent(Student student){
        mSchoolRepository.insertStudent(student);
    }
    public LiveData<List<Student>> getStudent(int id){
        mAllStudentsByGroup=mSchoolRepository.getStudents(id);
        return mAllStudentsByGroup;
    }

}
