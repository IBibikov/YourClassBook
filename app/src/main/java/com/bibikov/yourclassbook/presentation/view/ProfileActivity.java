package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.presentation.adapters.gradeadapter.GradeAdapter;
import com.bibikov.yourclassbook.presentation.adapters.studentAdapter.StudentAdapter;
import com.bibikov.yourclassbook.presentation.viewmodel.GradeViewModel;
import com.bibikov.yourclassbook.presentation.viewmodel.StudentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;

public class ProfileActivity extends AppCompatActivity {

    FloatingActionButton buttonAddNewGrade;
    GradeViewModel mGradeViewModel;
    TextView averageGrade;
    public static final int NEW_GRADE_ACTIVITY_REQUEST_CODE = 3;
    int idStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        buttonAddNewGrade = findViewById(R.id.add_new_grade);
        mGradeViewModel = new ViewModelProvider(this).get(GradeViewModel.class);
        averageGrade = (TextView) findViewById(R.id.average_grade);
        RecyclerView recyclerView = findViewById(R.id.recycler_for_grade);
        GradeAdapter gradeAdapter = new GradeAdapter(new GradeAdapter.GradeDiff());
        recyclerView.setAdapter(gradeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initFloatingButton(recyclerView, buttonAddNewGrade);
        Bundle arguments = getIntent().getExtras();
        idStudent = arguments.getInt("idStudentOwner");
        mGradeViewModel.getGrade(idStudent).observe(this, grades -> {
            gradeAdapter.submitList(grades);
            addNewGrade(buttonAddNewGrade);
        });
        mGradeViewModel.getGrade(idStudent).observe(this, grades -> {
            double average = 0.0;
            double temp = 0.0;
            double counter = 0.0;
            if (grades.isEmpty()) {
                averageGrade.setText("Добавьте оценку");
            } else {
                for (int i = 0; i < grades.size(); i++) {
                    temp += Integer.parseInt(grades.get(i).getGrade());
                    counter++;
                }
                average = temp / counter;
                String formattedDouble = String.format("%.1f", average);
                averageGrade.setText("Средний балл:" + formattedDouble);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_GRADE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String valueOfGrade = data.getStringExtra(AddNewGradeActivity.EXTRA_REPL);
            Grade grade = new Grade(valueOfGrade, idStudent);
            mGradeViewModel.insertGrade(grade);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Оценка не выставлена",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void addNewGrade(FloatingActionButton button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, AddNewGradeActivity.class);
                startActivityForResult(intent, NEW_GRADE_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void initFloatingButton(RecyclerView mRecyclerView, FloatingActionButton mButton) {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView mRecyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && mButton.isShown()) {
                    mButton.hide();
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView mRecyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    mButton.show();
                }
                super.onScrollStateChanged(mRecyclerView, newState);
            }
        });
    }

}