package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

public class StudentViewModel extends AndroidViewModel {

    public SchoolRepository mSchoolRepository;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository=new SchoolRepository(application);
    }
    public void insertStudent(Student student){
        mSchoolRepository.insertStudent(student);
    }
}
