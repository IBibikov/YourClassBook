package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.google.android.material.textfield.TextInputEditText;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import java.util.List;
/**
 * Экран для добавления группы в базу данных
 *
 * @author Бибиков Игорь
 */
public class AddNewGroupActivity extends AppCompatActivity {

    private TextInputEditText nameOfgroup;
    public static final String EXTRA_REPLY = "nameOfGroup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_group);
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