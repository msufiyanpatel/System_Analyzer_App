package com.example.systemanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.content.Context;
import android.os.Debug;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.io.File;

public class showstorage extends AppCompatActivity {

    private TextView memoryTextView;
    private TextView cpuTextView;
    private TextView storageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showstorage);

        memoryTextView = findViewById(R.id.memory_text_view);
        cpuTextView = findViewById(R.id.cpu_text_view);
        storageTextView = findViewById(R.id.storage_text_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateSystemResources();
    }

    private void updateSystemResources() {
        //Memory management
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        android.os.Debug.MemoryInfo[] memoryInfo = activityManager.getProcessMemoryInfo(new int[]{pid});
        int totalPrivateDirty = memoryInfo[0].getTotalPrivateDirty();
        String usedMemory = Formatter.formatShortFileSize(this, totalPrivateDirty);

        memoryTextView.setText("Used Memory: " + usedMemory);

        //CPU management
        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        long totalRAM = activityManager.getMemoryClass();
        cpuTextView.setText("Total Memory: " + totalRAM + " MB");

        //Storage management
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        long availableBlocks = stat.getAvailableBlocks();
        long usedStorage = (totalBlocks - availableBlocks) * blockSize;
        long totalStorage = totalBlocks * blockSize;
        long freeStorage = availableBlocks * blockSize;
        String usedStorageString = Formatter.formatFileSize(this, usedStorage);
        String totalStorageString = Formatter.formatFileSize(this, totalStorage);
        String freeStorageString = Formatter.formatFileSize(this, freeStorage);
        storageTextView.setText("Used Storage: " + usedStorageString + "\nFree Storage: " + freeStorageString + "\nTotal Storage: " + totalStorageString);

    }
}