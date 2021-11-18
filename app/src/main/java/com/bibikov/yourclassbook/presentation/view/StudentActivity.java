package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.bibikov.yourclassbook.presentation.viewmodel.StudentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.Bundle;
import android.view.View;

public class StudentActivity extends AppCompatActivity {
    FloatingActionButton buttonAddNewStudent;
    StudentViewModel mStudentViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        buttonAddNewStudent=findViewById(R.id.button_for_add_new_student);
        mStudentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        buttonAddNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle arguments = getIntent().getExtras();
                int idGroup=arguments.getInt("idGroupOwner");
                mStudentViewModel.insertStudent(idGroup);
            }
        });
    }
}