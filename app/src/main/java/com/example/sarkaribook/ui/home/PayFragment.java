package com.example.sarkaribook.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sarkaribook.Adapter.SubscriptionPlanAdapter;
import com.example.sarkaribook.Model.Subscription;
import com.example.sarkaribook.R;

import java.util.ArrayList;
import java.util.List;


public class PayFragment extends Fragment {

    public PayFragment() {
        // Required empty public constructor
    }
    View v;
    RecyclerView subscriptionRecyclerView;
    List<Subscription> subscriptionList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_pay, container, false);

        subscriptionRecyclerView = v.findViewById(R.id.subscriptionsPlansRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        subscriptionRecyclerView.setLayoutManager(linearLayoutManager);

        subscriptionList = new ArrayList<>();

        subscriptionList.add(new Subscription("Buy For 1 Month","In Just Rs 99"));
        subscriptionList.add(new Subscription("Buy For 3 Months", "In Just Rs 199"));
        subscriptionList.add(new Subscription("Buy For 6 Months","In Just Rs 299"));
        subscriptionList.add(new Subscription("Buy For 12 Months","In Just Rs 399"));

        SubscriptionPlanAdapter adapter = new SubscriptionPlanAdapter(subscriptionList,getActivity());
        subscriptionRecyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return v;
    }
}