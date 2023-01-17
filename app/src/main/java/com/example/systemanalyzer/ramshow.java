package com.example.systemanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ActivityManager;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Debug;
import androidx.appcompat.app.AppCompatActivity;
public class ramshow extends AppCompatActivity {

    private TextView mCpuUsageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramshow);

        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        long totalRAM = memoryInfo.totalMem;
        long availableRAM = memoryInfo.availMem;

        TextView totalRam = findViewById(R.id.total_ram);
        totalRam.setText("Total RAM: " + (totalRAM / (1024 * 1024)) + "MB");

        TextView usedRam = findViewById(R.id.used_ram);
        usedRam.setText("Used RAM: " + ((totalRAM - availableRAM) / (1024 * 1024)) + "MB");

        mCpuUsageTextView = findViewById(R.id.cpu_usage_text_view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                    final double cpuUsage = threadCpuTimeNanos / 1000000000.0;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mCpuUsageTextView.setText(String.format("CPU Usage: %.2f%%", cpuUsage));
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}