package com.bibikov.yourclassbook.presentation.adapters.gradeadapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.presentation.adapters.groupadapter.GroupViewHolder;

public class GradeViewHolder extends RecyclerView.ViewHolder  {

    private TextView gradeItemView;

    public GradeViewHolder(@NonNull View itemView) {
        super(itemView);
        gradeItemView = itemView.findViewById(R.id.item_grade);
    }
    public void bind(String text){
        gradeItemView.setText(text);
    }

}
