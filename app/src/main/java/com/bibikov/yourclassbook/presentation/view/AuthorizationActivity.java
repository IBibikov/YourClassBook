package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.db.AppDataBase;
import com.bibikov.yourclassbook.data.entity.Teacher;
import com.bibikov.yourclassbook.domain.repository.TeacherRepository;
import com.bibikov.yourclassbook.presentation.viewmodel.ViewModelTeacher;
import com.google.android.material.textfield.TextInputEditText;

public class AuthorizationActivity extends AppCompatActivity {



    TeacherRepository teacherRepository;
    private ViewModelTeacher viewModelTeacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        viewModelTeacher =  new ViewModelProvider(this).get(ViewModelTeacher.class);
        teacherRepository= viewModelTeacher.mTeacherRepository;
        insertTeacher(teacherRepository);

    }



    void insertTeacher(TeacherRepository teacherRepository){
        TextInputEditText nameOfTeacher= findViewById(R.id.name_of_teacher);
        TextInputEditText subjectOfTeacher= findViewById(R.id.subject_of_teacher);
        Button buttonForContinue=findViewById(R.id.button_continue);
        buttonForContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= nameOfTeacher.getText().toString();
                String subject= subjectOfTeacher.getText().toString();
                Teacher teacher= new Teacher(name,subject);
                teacherRepository.insert(teacher);
            }
        });
    }

}