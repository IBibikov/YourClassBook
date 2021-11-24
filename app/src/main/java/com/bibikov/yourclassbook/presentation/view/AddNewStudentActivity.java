package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import com.bibikov.yourclassbook.R;
import com.google.android.material.textfield.TextInputEditText;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
/**
 * Экран для добавления студента в базу данных
 *
 * @author Бибиков Игорь
 */
public class AddNewStudentActivity extends AppCompatActivity {

    private TextInputEditText nameOfStudent;
    public static final String EXTRA_REPLY = "nameOfStudent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        nameOfStudent = findViewById(R.id.name_student);
        Button buttonSaveStudent = findViewById(R.id.button_save_new_student);
        buttonSaveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(nameOfStudent.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String nameStudent = nameOfStudent.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, nameStudent);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });


    }
}