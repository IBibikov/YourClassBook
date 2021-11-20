package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Teacher;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;
import com.bibikov.yourclassbook.presentation.viewmodel.TeacherViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class AuthorizationActivity extends AppCompatActivity {


    SchoolRepository schoolRepository;
    private TeacherViewModel teacherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        teacherViewModel = new ViewModelProvider(this).get(TeacherViewModel.class);
        schoolRepository = teacherViewModel.mSchoolRepository;
        insertTeacher(teacherViewModel);

    }

    public void insertTeacher(TeacherViewModel teacherViewModel) {
        TextInputEditText nameOfTeacher = findViewById(R.id.name_of_teacher);
        TextInputEditText subjectOfTeacher = findViewById(R.id.subject_of_teacher);
        Button buttonForContinue = findViewById(R.id.button_continue);
        buttonForContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((TextUtils.isEmpty(nameOfTeacher.getText()))
                        || (TextUtils.isEmpty(subjectOfTeacher.getText()))) {
                    Toast.makeText(getApplicationContext(),"Заполните все поля", Toast.LENGTH_LONG).show();
                } else {
                    String name = nameOfTeacher.getText().toString();
                    String subject = subjectOfTeacher.getText().toString();
                    Teacher teacher = new Teacher(name, subject);
                    teacherViewModel.insertTeacher(teacher);
                    Intent intent = new Intent(AuthorizationActivity.this, GroupsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}