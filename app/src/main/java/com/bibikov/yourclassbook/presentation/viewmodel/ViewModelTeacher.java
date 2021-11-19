package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.bibikov.yourclassbook.data.entity.Teacher;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

public class ViewModelTeacher extends AndroidViewModel {


    public SchoolRepository mSchoolRepository;

    public ViewModelTeacher(Application application) {
        super(application);
        mSchoolRepository = new SchoolRepository(application);
    }

    public void insertTeacher(Teacher teacher) {
        mSchoolRepository.insertTeacher(teacher);
    }

    public void deleteAllTeachers(){
        mSchoolRepository.deleteAllTeacher();
    }

}
