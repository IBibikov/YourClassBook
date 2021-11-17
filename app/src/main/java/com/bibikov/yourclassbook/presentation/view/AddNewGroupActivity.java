package com.bibikov.yourclassbook.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.google.android.material.textfield.TextInputEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class AddNewGroupActivity extends AppCompatActivity {
    Button buttonSaveNewGroup;
    TextInputEditText nameOfgroup;
    GroupViewModel groupViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_group);
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        addNewGroup(groupViewModel);
    }
    public void addNewGroup(GroupViewModel groupViewModel){
        buttonSaveNewGroup= findViewById(R.id.button_save_new_group);
        nameOfgroup=findViewById(R.id.name_of_group);
        List<Integer> idTeacher = groupViewModel.getIdOfTeacher();
        buttonSaveNewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameOfGroup=nameOfgroup.getText().toString();
                int idForRelation= idTeacher.get(0);
                Group group= new Group(nameOfGroup,idForRelation);
                groupViewModel.insertGroup(group);

            }
        });
    }
}