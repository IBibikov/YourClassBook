package com.bibikov.yourclassbook.presentation.view;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.domain.repository.SchoolRepository;
import com.bibikov.yourclassbook.presentation.adapters.groupadapter.GroupAdapter;
import com.bibikov.yourclassbook.presentation.adapters.groupadapter.GroupViewHolder;
import com.bibikov.yourclassbook.presentation.viewmodel.GroupViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroupsActivity extends AppCompatActivity implements GroupViewHolder.OnGroupListener {

    public static final int NEW_GROUP_ACTIVITY_REQUEST_CODE = 1;
    FloatingActionButton buttonAddNewGroup;
    private GroupViewModel mGroupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        buttonAddNewGroup = findViewById(R.id.button_for_add_new_group);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_for_group);
        final GroupAdapter adapter = new GroupAdapter(new GroupAdapter.GroupDiff(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mGroupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        initFloatingButton(recyclerView, buttonAddNewGroup);
        mGroupViewModel.getAllGroups().observe(this, groups -> {
            adapter.submitList(groups);
        });
        addNewGroup(buttonAddNewGroup);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_GROUP_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            List<Integer> idTeacher = mGroupViewModel.getIdOfTeacher();
            int idForRelation = idTeacher.get(0);
            Group group = new Group(data.getStringExtra(AddNewGroupActivity.EXTRA_REPLY), idForRelation);
            mGroupViewModel.insertGroup(group);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Класс не добавлен",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void addNewGroup(FloatingActionButton button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroupsActivity.this, AddNewGroupActivity.class);
                startActivityForResult(intent, NEW_GROUP_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onGroupClick(int position) {
        int idOfgroupForRelation = mGroupViewModel.idOfGroup(position);
        Intent intent = new Intent(GroupsActivity.this, StudentActivity.class);
        intent.putExtra("idGroupOwner", idOfgroupForRelation);
        startActivity(intent);

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

