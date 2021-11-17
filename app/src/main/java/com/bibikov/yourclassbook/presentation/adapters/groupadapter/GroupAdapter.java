package com.bibikov.yourclassbook.presentation.adapters.groupadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.bibikov.yourclassbook.R;
import com.bibikov.yourclassbook.data.entity.Group;

public class GroupAdapter extends ListAdapter<Group,GroupViewHolder> {

    private GroupViewHolder.OnGroupListener mOnGroupListener;
    public GroupAdapter(@NonNull DiffUtil.ItemCallback<Group> diffCallback, GroupViewHolder.OnGroupListener onGroupListener) {
        super(diffCallback);
        this.mOnGroupListener=onGroupListener;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new GroupViewHolder(view,mOnGroupListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        Group current=getItem(position);
        holder.bind(current.getNameOfGroup());
    }


    public static class GroupDiff extends DiffUtil.ItemCallback<Group> {

        @Override
        public boolean areItemsTheSame(@NonNull Group oldItem, @NonNull Group newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Group oldItem, @NonNull Group newItem) {
            return oldItem.getNameOfGroup().equals(newItem.getNameOfGroup());
        }
    }
}
