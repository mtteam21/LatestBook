package com.example.sarkaribook.Adapter;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sarkaribook.AllActivities.MainActivity;
import com.example.sarkaribook.Model.Ebook;
import com.example.sarkaribook.R;

import java.io.File;
import java.util.List;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.viewHolder> {
    List<Ebook> ebookList;
    Context context;

    public EbookAdapter(List<Ebook> ebookList,Context context) {
        this.ebookList = ebookList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ebook,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(ebookList.get(position).title);
        holder.pdfDesc.setText(ebookList.get(position).description);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Download Start", Toast.LENGTH_SHORT).show();
                String getUrl = ebookList.get(position).file_url ;

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(getUrl));
                request.setTitle("SL_"+ebookList.get(position).title);
                request.setMimeType("application/pdf");
                request.setDescription("Description");
                request.setAllowedOverMetered(true);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOCUMENTS,"SL_"+ebookList.get(position).title);
                DownloadManager dm = (DownloadManager) view.getContext().getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ebookList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textView,pdfDesc;
        ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.pdfTitle);
            pdfDesc = itemView.findViewById(R.id.pdfDescription);
            imageView = itemView.findViewById(R.id.downloadBtn);

        }

    }


}
