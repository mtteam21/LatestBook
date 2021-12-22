package com.example.sarkaribook.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarkaribook.Model.Subscription;
import com.example.sarkaribook.R;
import com.shreyaspatil.EasyUpiPayment.EasyUpiPayment;
import com.shreyaspatil.EasyUpiPayment.listener.PaymentStatusListener;
import com.shreyaspatil.EasyUpiPayment.model.TransactionDetails;

import org.w3c.dom.Text;

import java.util.List;


public class SubscriptionPlanAdapter extends RecyclerView.Adapter<SubscriptionPlanAdapter.viewHolder> implements PaymentStatusListener {

    List<Subscription> subscriptionList;
    Activity activity;
    String passThisForDuration;
    public SubscriptionPlanAdapter(List<Subscription> subscriptionList,Activity context) {
        this.subscriptionList = subscriptionList;
        this.activity = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_buy_subscription,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.priceTextView.setText(subscriptionList.get(position).getAmountText());
        holder.durationTextView.setText(subscriptionList.get(position).getMonthText());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passThisForAmount = subscriptionList.get(position).getAmountText();
                passThisForDuration = subscriptionList.get(position).getMonthText();
                extractInt(passThisForAmount);

                makePayment(extractInt(passThisForDuration)+".00", "sangharsh3599@oksbi", "name", "desc", "0");
            }
        });
    }

    private void makePayment(String amount, String upi, String name, String desc, String transactionId) {

        Toast.makeText(activity, amount, Toast.LENGTH_SHORT).show();
        final EasyUpiPayment easyUpiPayment = new EasyUpiPayment.Builder()
                .with(activity)
                // on below line we are adding upi id.
                .setPayeeVpa(upi)
                // on below line we are setting name to which we are making oayment.
                .setPayeeName(name)
                // on below line we are passing transaction id.
                .setTransactionId(transactionId)
                // on below line we are passing transaction ref id.
                .setTransactionRefId(transactionId)
                // on below line we are adding description to payment.
                .setDescription(desc)
                // on below line we are passing amount which is being paid.
                .setAmount(amount)
                // on below line we are calling a build method to build this ui.
                .build();
        // on below line we are calling a start
        // payment method to start a payment.
        easyUpiPayment.startPayment();
        // on below line we are calling a set payment
        // status listener method to call other payment methods.
        easyUpiPayment.setPaymentStatusListener(this);
    }

    static String extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }
    @Override
    public int getItemCount() {
        return subscriptionList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView durationTextView,priceTextView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            durationTextView = itemView.findViewById(R.id.getDurationTextView);
            priceTextView = itemView.findViewById(R.id.getSubscriptionPrice);
        }
    }

    @Override
    public void onTransactionCompleted(TransactionDetails transactionDetails) {
        // on below line we are getting details about transaction when completed.
        String transcDetails = transactionDetails.getStatus().toString() + "\n" + "Transaction ID : " + transactionDetails.getTransactionId();

        // on below line we are setting details to our text view.

    }

    @Override
    public void onTransactionSuccess() {

        // this method is called when transaction is successful and we are displaying a toast message.
        Toast.makeText(activity, "Transaction successfully completed..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTransactionSubmitted() {
        // this method is called when transaction is done
        // but it may be successful or failure.
        Log.e("TAG", "TRANSACTION SUBMIT");
    }

    @Override
    public void onTransactionFailed() {
        // this method is called when transaction is failure.
        Toast.makeText(activity, "Failed to complete transaction", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onTransactionCancelled() {

        extractInt(passThisForDuration);
        // this method is called when transaction is cancelled.
        Toast.makeText(activity, "Transaction cancelled..", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAppNotFound() {
        // this method is called when the users device is not having any app installed for making payment.
        Toast.makeText(activity, "No app found for making transaction..", Toast.LENGTH_SHORT).show();
    }
}
