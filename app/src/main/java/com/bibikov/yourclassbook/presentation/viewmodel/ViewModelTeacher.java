package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.bibikov.yourclassbook.data.entity.Teacher;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

import java.util.List;

import io.reactivex.Flowable;

public class ViewModelTeacher extends AndroidViewModel {


    public SchoolRepository mSchoolRepository;
    List<Integer> allIdOfTeacher;
    public ViewModelTeacher(Application application) {
        super(application);
        mSchoolRepository = new SchoolRepository(application);
    }

    public void insertTeacher(Teacher teacher) {
        mSchoolRepository.insert(teacher);
    }

    public Flowable<List<Integer>> getIdTeacher(){
        return mSchoolRepository.getIdTeacher(){
            
        }

    }

}
