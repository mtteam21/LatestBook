package com.example.sarkaribook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarkaribook.Model.Subscription;
import com.example.sarkaribook.R;

import java.util.List;


public class SubscriptionPlanAdapter extends RecyclerView.Adapter<SubscriptionPlanAdapter.viewHolder> {

    List<Subscription> subscriptionList;

    public SubscriptionPlanAdapter(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buy_subscription,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return subscriptionList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
