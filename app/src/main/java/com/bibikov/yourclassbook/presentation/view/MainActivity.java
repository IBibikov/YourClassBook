package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bibikov.yourclassbook.R;

public class MainActivity extends AppCompatActivity {
    private Button buttonContinue;
    private Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        buttonStart= findViewById(R.id.button_start);
        buttonContinue=findViewById(R.id.button_for_continue);
        startForNewTeacher(buttonStart);
        continueForOldTeacher(buttonContinue);
    }


    public void startForNewTeacher(View view){
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, AuthorizationActivity.class);
                startActivity(intent);
            }
        });
    }
    public void continueForOldTeacher(View view){
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,GroupsActivity.class);
                startActivity(intent);
            }
        });

    }
}