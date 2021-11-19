package com.bibikov.yourclassbook.presentation.adapters.studentAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bibikov.yourclassbook.R;

public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView studentItemView;
    OnStudentListener onStudentListener;

    public StudentViewHolder(@NonNull View itemView,OnStudentListener onStudentListener) {
        super(itemView);
        studentItemView = itemView.findViewById(R.id.item_group);
        this.onStudentListener=onStudentListener;
        itemView.setOnClickListener(this);
    }

    public void bind(String text) {
        studentItemView.setText(text);
    }

    @Override
    public void onClick(View view) {
        onStudentListener.onStudentClick(getAdapterPosition());
    }


    public interface OnStudentListener{
        void onStudentClick(int position);
    }
}
