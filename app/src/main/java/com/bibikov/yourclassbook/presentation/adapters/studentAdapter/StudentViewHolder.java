package com.bibikov.yourclassbook.presentation.adapters.studentAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bibikov.yourclassbook.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView studentItemView;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        studentItemView=itemView.findViewById(R.id.item_group);
    }
    public void bind(String text){
        studentItemView.setText(text);
    }
}
