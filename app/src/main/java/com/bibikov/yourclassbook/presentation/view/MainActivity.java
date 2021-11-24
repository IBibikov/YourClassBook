package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.bibikov.yourclassbook.presentation.viewmodel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Первый экран приложения, предлагающий действия "продолжить" при существующем учителе
 * и "начать" при его отсутствии
 *
 * @author Бибиков Игорь
 */
public class MainActivity extends AppCompatActivity {
    private Button buttonContinue;
    private Button buttonStart;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonStart = findViewById(R.id.button_start);
        buttonContinue = findViewById(R.id.button_for_continue);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        startForNewTeacher();
        continueForOldTeacher();
    }


    public void startForNewTeacher() {
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(mainViewModel.isTeacherExist())) {
                    Toast.makeText(getApplicationContext(), "Вы уже зарегистрированны", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, AuthorizationActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void continueForOldTeacher() {
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainViewModel.isTeacherExist()) {
                    Toast.makeText(getApplicationContext(), "Вы не прошли регистрацию", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, GroupsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}