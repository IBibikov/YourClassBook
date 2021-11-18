package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import com.bibikov.yourclassbook.R;
import com.google.android.material.textfield.TextInputEditText;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class AddNewStudentActivity extends AppCompatActivity {

    private TextInputEditText nameOfgroup;
    public static final String EXTRA_REPLY = "nameOfGroup";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        nameOfgroup = findViewById(R.id.name_of_group);
        Button buttonSaveGroup = findViewById(R.id.button_save_new_group);
        buttonSaveGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(nameOfgroup.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String nameGroup = nameOfgroup.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, nameGroup);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });


    }
}