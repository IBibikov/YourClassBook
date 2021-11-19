package com.bibikov.yourclassbook.presentation.adapters.gradeadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Grade;
import com.bibikov.yourclassbook.data.entity.Group;
import com.bibikov.yourclassbook.presentation.adapters.groupadapter.GroupViewHolder;

public class GradeAdapter extends ListAdapter<Grade, GradeViewHolder> {

    public GradeAdapter(@NonNull DiffUtil.ItemCallback<Grade> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public GradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_item, parent, false);
        return new GradeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeViewHolder holder, int position) {
        Grade current=getItem(position);
        holder.bind(current.getGrade());
    }

    public static class GradeDiff extends DiffUtil.ItemCallback<Grade> {

        @Override
        public boolean areItemsTheSame(@NonNull Grade oldItem, @NonNull Grade newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Grade oldItem, @NonNull Grade newItem) {
            return oldItem.getGrade().equals(newItem.getGrade());
        }
    }
}
