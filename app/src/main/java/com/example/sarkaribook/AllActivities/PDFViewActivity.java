package com.example.sarkaribook.AllActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Space;

import com.example.sarkaribook.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PDFViewActivity extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        pdfView = findViewById(R.id.pdfView);

        String path = getIntent().getStringExtra("path");
        Log.e("P",path);
        pdfView.fromFile(new File(path))
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .load();

    }
}