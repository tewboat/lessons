package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    Button startButton, nextButton;

    ProgressBar progressBar;

    BackgroundMusicService backgroundSoundService;

    ServiceConnection sConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initUi();

        sConn = new ServiceConnection() {

            public void onServiceConnected(ComponentName name, IBinder binder) {
                backgroundSoundService = ((BackgroundMusicService.MyBinder) binder).getService();
            }

            public void onServiceDisconnected(ComponentName name) {
            }
        };

        Intent musicServiceIntent = new Intent(this, BackgroundMusicService.class);
        startService(musicServiceIntent);
        bindService(musicServiceIntent, sConn, 0);
        new ProgressUpdaterTask().execute();

    }

    private void initUi() {
        startButton = findViewById(R.id.startButton);
        nextButton = findViewById(R.id.nextButton);
        progressBar = findViewById(R.id.progressBar);

        startButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startButton:
                backgroundSoundService.onStart();
                if (backgroundSoundService.mediaPlayer.isPlaying()) {
                    startButton.setText("pause");
                } else {
                    startButton.setText("play");
                }
                break;
            case R.id.nextButton:
                backgroundSoundService.onNext();
                break;
        }
    }

    class ProgressUpdaterTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress();
            }
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(backgroundSoundService.mediaPlayer.getCurrentPosition() / 1000);
        }
    }
}
