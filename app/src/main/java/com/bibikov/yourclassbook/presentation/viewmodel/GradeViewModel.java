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

    public void insertGrade(Grade grade) {
        mSchoolRepository.insertGrade(grade);
    }

    public LiveData<List<Grade>> getGrade(int idOwner) {
        return mAllGradesByStudent = mSchoolRepository.getAllGrade(idOwner);
    }

    public double getAverageGrade(int idOwner) {
        double average = 0;
        int temp = 0;
        int counter = 0;
        List<Grade> listGrade = mSchoolRepository.getAllGrade(idOwner).getValue();
        if (listGrade == null) {
            return 0;
        } else {
            for (int i = 0; i < listGrade.size(); i++) {
                temp += Integer.parseInt(listGrade.get(i).getGrade());
                counter++;
            }
            average = temp / counter;
            return average;
        }
    }
}
