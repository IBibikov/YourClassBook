package com.bibikov.yourclassbook.presentation.adapters.groupadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bibikov.yourclassbook.R;

public class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView groupItemView;
    OnGroupListener onGroupListener;

    public GroupViewHolder(@NonNull View itemView,OnGroupListener onGroupListener) {
        super(itemView);
        groupItemView = itemView.findViewById(R.id.item_group);
        this.onGroupListener=onGroupListener;
        itemView.setOnClickListener(this);
    }
    public void bind(String text){
        groupItemView.setText(text);
    }


    @Override
    public void onClick(View view) {
        onGroupListener.onGroupClick(getAdapterPosition());
    }

    public interface OnGroupListener{
        void onGroupClick(int position);
    }

}
