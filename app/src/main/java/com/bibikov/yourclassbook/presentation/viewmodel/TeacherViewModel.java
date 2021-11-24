package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.bibikov.yourclassbook.data.entity.Teacher;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;
/**
 * ViewModel для управления экраном представления сущности "учитель"
 *
 * @author Бибиков Игорь
 */
public class TeacherViewModel extends AndroidViewModel {
    public SchoolRepository mSchoolRepository;

    public TeacherViewModel(Application application) {
        super(application);
        mSchoolRepository = new SchoolRepository(application);
    }

    public void insertTeacher(Teacher teacher) {
        mSchoolRepository.insertTeacher(teacher);
    }
}
