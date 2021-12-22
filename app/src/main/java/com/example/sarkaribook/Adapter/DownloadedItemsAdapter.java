package com.example.sarkaribook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarkaribook.Model.Category;
import com.example.sarkaribook.R;

import java.util.List;

public class DownloadedItemsAdapter extends RecyclerView.Adapter<DownloadedItemsAdapter.viewHOLDER> {
    private List<Category> downloadItemsList;

    public DownloadedItemsAdapter(List<Category> downloadItemsList) {
        this.downloadItemsList = downloadItemsList;
    }

    @NonNull
    @Override
    public viewHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_download,parent,false);
        return new viewHOLDER(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHOLDER holder, int position) {

    }

    @Override
    public int getItemCount() {
        return downloadItemsList.size();
    }

    public class viewHOLDER extends RecyclerView.ViewHolder {
        public viewHOLDER(@NonNull View itemView) {
            super(itemView);
        }
    }
}
