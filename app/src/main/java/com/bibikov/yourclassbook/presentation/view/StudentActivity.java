package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.presentation.adapters.groupadapter.GroupAdapter;
import com.bibikov.yourclassbook.presentation.adapters.studentAdapter.StudentAdapter;
import com.bibikov.yourclassbook.presentation.adapters.studentAdapter.StudentViewHolder;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.bibikov.yourclassbook.presentation.viewmodel.StudentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class StudentActivity extends AppCompatActivity implements StudentViewHolder.OnStudentListener {
    FloatingActionButton buttonAddNewStudent;
    StudentViewModel mStudentViewModel;
    public static final int NEW_STUDENT_ACTIVITY_REQUEST_CODE= 2;
    int idGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        buttonAddNewStudent=findViewById(R.id.button_for_add_new_student);
        mStudentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_for_student);
        final StudentAdapter studentAdapter= new StudentAdapter(new StudentAdapter.StudentDiff(),this);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Bundle arguments = getIntent().getExtras();
        idGroup=arguments.getInt("idGroupOwner");
        mStudentViewModel.getStudent(idGroup).observe(this,students -> {
            studentAdapter.submitList(students);
        });
        addNewStudent(buttonAddNewStudent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_STUDENT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String studentName= data.getStringExtra(AddNewStudentActivity.EXTRA_REPLY);
            Student student = new Student(idGroup,studentName);
            mStudentViewModel.insertStudent(student);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Класс не добавлен",
                    Toast.LENGTH_LONG).show();
        }

    }
    public void addNewStudent( FloatingActionButton button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentActivity.this, AddNewStudentActivity.class);
                startActivityForResult(intent, NEW_STUDENT_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onStudentClick(int position) {
        Intent intent = new Intent(StudentActivity.this, ProfileActivity.class);
        startActivity(intent);

    }
}