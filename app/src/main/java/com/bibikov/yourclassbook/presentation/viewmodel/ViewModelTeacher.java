package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bibikov.yourclassbook.data.entity.Teacher;
import com.bibikov.yourclassbook.domain.repository.TeacherRepository;

public class ViewModelTeacher extends AndroidViewModel {


    public TeacherRepository mTeacherRepository;
    public ViewModelTeacher( Application application) {
        super(application);
        mTeacherRepository = new TeacherRepository(application);
    }
    void insert(Teacher teacher){
        mTeacherRepository.insert(teacher);
    }
}
