package com.bibikov.yourclassbook.presentation;

import androidx.appcompat.app.AppCompatActivity;
import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.db.GroupDao.*;
import com.bibikov.yourclassbook.data.entity.*;
import com.bibikov.yourclassbook.data.db.AppDataBase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_group);


    }
}