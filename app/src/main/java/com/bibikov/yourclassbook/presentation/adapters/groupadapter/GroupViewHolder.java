package com.bibikov.yourclassbook.presentation.adapters.groupadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bibikov.yourclassbook.R;

public class GroupViewHolder extends RecyclerView.ViewHolder {

    private TextView groupItemView;

    public GroupViewHolder(@NonNull View itemView) {
        super(itemView);
        groupItemView = itemView.findViewById(R.id.item_group);
    }
    public void bind(String text){
        groupItemView.setText(text);
    }
    static GroupViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);
        return new GroupViewHolder(view);
    }

}
