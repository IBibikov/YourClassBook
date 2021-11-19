package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

import java.util.List;

public class GradeViewModel extends AndroidViewModel {

    private LiveData<List<Grade>> mAllGradesByStudent;
    public SchoolRepository mSchoolRepository;


    public GradeViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository = new SchoolRepository(application);
    }

    public void insertGrade(Grade grade){
        mSchoolRepository.insertGrade(grade);
    }
}
