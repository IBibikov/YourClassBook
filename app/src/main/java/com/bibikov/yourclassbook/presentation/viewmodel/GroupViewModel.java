package com.bibikov.yourclassbook.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupViewModel extends AndroidViewModel {

    public SchoolRepository mSchoolRepository;
    private LiveData<List<Group>> mAllGroups;

    public GroupViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository = new SchoolRepository(application);
        mAllGroups = mSchoolRepository.getmAllGroups();
    }

    public void insertGroup(Group group) {
        mSchoolRepository.insertGroup(group);
    }

    public List<Integer> getIdOfTeacher() {
        return mSchoolRepository.getIdAllTeacher();
    }

    public LiveData<List<Group>> getAllGroups() {
        return mAllGroups;
    }

    public int idOfGroup(int position){
       return mAllGroups.getValue().get(position).getGroupId();
    }
}
