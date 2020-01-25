package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

/// Сервис воспроизведения музыки
public class BackgroundMusicService extends Service {

    MediaPlayer mediaPlayer;

    public MyBinder binder = new MyBinder();

    public BackgroundMusicService() {

    }

    class MyBinder extends Binder {
        BackgroundMusicService getService() {
            return BackgroundMusicService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.acdc);
    }

    public IBinder onBind(Intent arg0) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }


    public void onStart() {
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
        else
            mediaPlayer.start();
    }

    public void onNext() {
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.marley);
        mediaPlayer.start();
    }

    public void onPrev() {

    }

}
