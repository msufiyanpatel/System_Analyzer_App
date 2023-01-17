package com.example.systemanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Build;
import android.widget.TextView;

public class specification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specification);

        TextView model = findViewById(R.id.model);
        model.setText("Model: " + Build.MODEL);

        TextView manufacturer = findViewById(R.id.manufacturer);
        manufacturer.setText("Manufacturer: " + Build.MANUFACTURER);

        TextView brand = findViewById(R.id.brand);
        brand.setText("Brand: " + Build.BRAND);
        TextView product = findViewById(R.id.product);
        product.setText("Product: " + Build.PRODUCT);

        TextView device = findViewById(R.id.device);
        device.setText("Device: " + Build.DEVICE);

        TextView board = findViewById(R.id.board);
        board.setText("Board: " + Build.BOARD);

        TextView display = findViewById(R.id.display);
        display.setText("Display: " + Build.DISPLAY);

        TextView version = findViewById(R.id.version);
        version.setText("Version: " + Build.VERSION.RELEASE);

        TextView cpu_abi = findViewById(R.id.cpu_abi);
        cpu_abi.setText("CPU ABI: " + Build.CPU_ABI);

        TextView cpu_abi2 = findViewById(R.id.cpu_abi2);
        cpu_abi2.setText("CPU ABI2: " + Build.CPU_ABI2);

        TextView hardware = findViewById(R.id.hardware);
        hardware.setText("Hardware: " + Build.HARDWARE);
    }
}