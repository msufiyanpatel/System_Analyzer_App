package com.example.systemanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class volumeboost extends AppCompatActivity {
    Button increaseVolumeButton;
    AudioManager audio;

    private TextView volumeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumeboost);

        audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volumeText = findViewById(R.id.volume_text);
        updateVolumeText();
    }
    public void boostVolume(View view) {
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        if (currentVolume + (maxVolume / 10) > maxVolume) {
            audio.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);
        } else {
            audio.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + (maxVolume / 10), 0);
        }
        updateVolumeText();

        increaseVolumeButton = findViewById(R.id.increase_volume_button);
        increaseVolumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxVolume = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
                int increaseVolume = maxVolume * 2;
                int newVolume = currentVolume + increaseVolume;
                if (newVolume > maxVolume) {
                    newVolume = maxVolume;
                }
                audio.setStreamVolume(AudioManager.STREAM_MUSIC, newVolume, 0);
                Toast.makeText(volumeboost.this, "Volume Increased to 200%", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void decreaseVolume(View view) {
        int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        int minVolume = 0;
        if (currentVolume - (audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 10) < minVolume) {
            audio.setStreamVolume(AudioManager.STREAM_MUSIC, minVolume, 0);
        } else {
            audio.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - (audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 10), 0);
        }
        updateVolumeText();
    }
    private void updateVolumeText() {
        volumeText.setText("Current Volume: " + audio.getStreamVolume(AudioManager.STREAM_MUSIC));
    }
}