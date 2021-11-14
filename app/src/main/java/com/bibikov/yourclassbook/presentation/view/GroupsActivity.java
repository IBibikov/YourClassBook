package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroupsActivity extends AppCompatActivity {


    private SchoolRepository schoolRepository;
    private GroupViewModel groupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        schoolRepository = groupViewModel.mSchoolRepository;
        insertGroup(groupViewModel);
    }

    public void insertGroup(GroupViewModel groupViewModel) {
        FloatingActionButton button = findViewById(R.id.button_for_add_new_group);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
