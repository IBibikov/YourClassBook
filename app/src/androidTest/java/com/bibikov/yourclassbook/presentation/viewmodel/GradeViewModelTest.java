package com.bibikov.yourclassbook.presentation.viewmodel;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.bibikov.yourclassbook.domain.repository.SchoolRepository;
import com.bibikov.yourclassbook.domain.repository.SchoolRepositoryTest;

import org.junit.Before;
import org.junit.Test;

public class GradeViewModelTest {

    SchoolRepository schoolRepository;

    @Before
    public void init(){
        Context context = ApplicationProvider.getApplicationContext();
        schoolRepository=new SchoolRepository(context);
    }

    @Test
    public void insertGrade() {

    }

    @Test
    public void getGrade() {
        //TODO
    }

    @Test
    public void getAverageGrade() {
        //TODO
    }
}