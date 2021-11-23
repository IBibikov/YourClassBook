package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bibikov.yourclassbook.data.entity.Teacher;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    public SchoolRepository mSchoolRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository = new SchoolRepository(application);
    }

    public boolean isTeacherExist() {
        return mSchoolRepository.getIdAllTeacher().isEmpty();
    }
}
