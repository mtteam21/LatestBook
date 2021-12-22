package com.example.sarkaribook.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sarkaribook.Adapter.DownloadedItemsAdapter;
import com.example.sarkaribook.Model.Category;
import com.example.sarkaribook.R;

import java.util.ArrayList;
import java.util.List;

public class DownloadFragment extends Fragment {


    public DownloadFragment() {
        // Required empty public constructor
    }

    RecyclerView downloadedItemsRecyclerView;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_download, container, false);

        downloadedItemsRecyclerView = v.findViewById(R.id.downloadedItemsRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        downloadedItemsRecyclerView.setLayoutManager(linearLayoutManager);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("",""));
        categoryList.add(new Category("",""));
        categoryList.add(new Category("",""));

        DownloadedItemsAdapter adapter = new DownloadedItemsAdapter(categoryList);
        downloadedItemsRecyclerView.setAdapter(adapter);



        // Inflate the layout for this fragment
        return v;
    }
}