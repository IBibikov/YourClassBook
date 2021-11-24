package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.bibikov.yourclassbook.R;
import com.google.android.material.textfield.TextInputEditText;
/**
 * Экран для добавления оценки в базу данных
 *
 * @author Бибиков Игорь
 */
public class AddNewGradeActivity extends AppCompatActivity {

    private TextInputEditText valueOfGrade;
    public static final String EXTRA_REPL = "valueOfGrade";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_grade_acrivity);
        valueOfGrade = findViewById(R.id.value_of_grade);
        Button buttonSaveGrade = findViewById(R.id.button_for_save_new_grade);
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(1);
        valueOfGrade.setFilters(filterArray);
        buttonSaveGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(valueOfGrade.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String value = valueOfGrade.getText().toString();
                    replyIntent.putExtra(EXTRA_REPL, value);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}