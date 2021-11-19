package com.bibikov.yourclassbook.presentation.adapters.studentAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.data.entity.Student;
import com.bibikov.yourclassbook.presentation.adapters.groupadapter.GroupViewHolder;

public class StudentAdapter extends ListAdapter<Student,StudentViewHolder> {

    private StudentViewHolder.OnStudentListener mOnStudentListener;
    public StudentAdapter(@NonNull DiffUtil.ItemCallback<Student> diffCallback, StudentViewHolder.OnStudentListener onStudentListener) {
        super(diffCallback);
        this.mOnStudentListener=onStudentListener;
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentViewHolder(view,mOnStudentListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student current=getItem(position);
        holder.bind(current.getNameOfStudent());
    }
    public static class StudentDiff extends DiffUtil.ItemCallback<Student> {

        @Override
        public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
            return oldItem.getNameOfStudent().equals(newItem.getNameOfStudent());
        }
    }
}
