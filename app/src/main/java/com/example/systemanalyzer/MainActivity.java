package com.example.systemanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    Button storage;
    Button ram;
    Button volume;
    Button specs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storage = (Button) findViewById(R.id.storage);
        ram = (Button) findViewById(R.id.ram);
        volume = (Button) findViewById(R.id.volume);
        specs = (Button) findViewById(R.id.specs);


        storage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, showstorage.class);

            startActivity(intent);
        });

        ram.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ramshow.class);

            startActivity(intent);
        });


        volume.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, volumeboost.class);

            startActivity(intent);
        });


        specs.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, specification.class);

            startActivity(intent);
        });
    }
}