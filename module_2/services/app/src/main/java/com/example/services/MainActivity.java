package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ServiceConnection sConn;
    Intent backgroundSoundServiceIntent;
    BackgroundSoundService backgroundSoundService;

    Button playButton, nextButton;
    ProgressBar progressBar;
    ProgressbarUpdaterTask updaterTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundSoundServiceIntent = new Intent(this, BackgroundSoundService.class);
        sConn = new ServiceConnection() {

            public void onServiceConnected(ComponentName name, IBinder binder) {
                backgroundSoundService = ((BackgroundSoundService.MyBinder) binder).getService();
            }

            public void onServiceDisconnected(ComponentName name) {
            }
        };

        playButton = findViewById(R.id.play);
        nextButton = findViewById(R.id.nextSound);
        progressBar = findViewById(R.id.musicBar);

        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(backgroundSoundServiceIntent);
        bindService(backgroundSoundServiceIntent, sConn, 0);
        updaterTask = new ProgressbarUpdaterTask();
        updaterTask.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                backgroundSoundService.startPauseMusic();
                if (backgroundSoundService.player.isPlaying()) {
                    playButton.setText("pause");
                } else {
                    playButton.setText("play");
                }

                break;
            case R.id.nextSound:
                backgroundSoundService.nextSound();
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    class ProgressbarUpdaterTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressBar.setProgress(0);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(backgroundSoundService.player.getCurrentPosition() / 1000);
            Log.d("MUSIC", "play: " + backgroundSoundService.player.getCurrentPosition());
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                publishProgress();
            }
        }

    }
}
