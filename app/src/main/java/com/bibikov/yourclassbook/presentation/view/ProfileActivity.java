package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.presentation.adapters.gradeadapter.GradeAdapter;
import com.bibikov.yourclassbook.presentation.adapters.studentAdapter.StudentAdapter;
import com.bibikov.yourclassbook.presentation.viewmodel.GradeViewModel;
import com.bibikov.yourclassbook.presentation.viewmodel.StudentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileActivity extends AppCompatActivity {

    FloatingActionButton buttonAddNewGrade;
    GradeViewModel mGradeViewModel;
    public static final int NEW_GRADE_ACTIVITY_REQUEST_CODE= 3;
    int idStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        buttonAddNewGrade=findViewById(R.id.add_new_grade);
        mGradeViewModel= new ViewModelProvider(this).get(GradeViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recycler_for_grade);
        GradeAdapter gradeAdapter = new GradeAdapter(new GradeAdapter.GradeDiff());
        recyclerView.setAdapter(gradeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Bundle arguments = getIntent().getExtras();
        idStudent=arguments.getInt("idStudentOwner");
        mGradeViewModel.getGrade(idStudent).observe(this,grades -> {
            gradeAdapter.submitList(grades);
            addNewGrade(buttonAddNewGrade);
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_GRADE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String valueOfGrade= data.getStringExtra(AddNewGradeActivity.EXTRA_REPL);
            Grade grade= new Grade(valueOfGrade,idStudent);
            mGradeViewModel.insertGrade(grade);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Класс не добавлен",
                    Toast.LENGTH_LONG).show();
        }
}
    public void addNewGrade( FloatingActionButton button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, AddNewGradeActivity.class);
                startActivityForResult(intent, NEW_GRADE_ACTIVITY_REQUEST_CODE);
            }
        });
    }
}