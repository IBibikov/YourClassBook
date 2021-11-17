package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroupsActivity extends AppCompatActivity {



    FloatingActionButton button;
    List<Integer> idOfTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        button = findViewById(R.id.button_for_add_new_group);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GroupsActivity.this,AddNewGroupActivity.class);
                startActivity(intent);
            }
        });
    }


    }

