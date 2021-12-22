package com.example.sarkaribook.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.sarkaribook.Adapter.PeopleAdapter;
import com.example.sarkaribook.Model.User;
import com.example.sarkaribook.R;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment {

    public UserFragment() {
        // Required empty public constructor
    }

    View v;
    PeopleAdapter peopleAdapter;
    RecyclerView recyclerView;
    List<User> userList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_user, container, false);

        recyclerView = v.findViewById(R.id.peopletemsRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        userList = new ArrayList<>();

        userList.add(new User(""));
        userList.add(new User(""));
        userList.add(new User(""));
        userList.add(new User(""));
        userList.add(new User(""));
        userList.add(new User(""));
        userList.add(new User(""));
        userList.add(new User(""));

        peopleAdapter = new PeopleAdapter(userList);
        recyclerView.setAdapter(peopleAdapter);

        return v;
    }
}