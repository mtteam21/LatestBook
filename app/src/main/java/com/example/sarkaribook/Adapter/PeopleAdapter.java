package com.example.sarkaribook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarkaribook.Model.User;
import com.example.sarkaribook.R;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.viewholder> {
     private List<User> userList;

    public PeopleAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        public viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
