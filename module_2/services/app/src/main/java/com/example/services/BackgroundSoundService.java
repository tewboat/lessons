package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    public MediaPlayer player;
    public MyBinder binder = new MyBinder();

    class MyBinder extends Binder {
        BackgroundSoundService getService() {
            return BackgroundSoundService.this;
        }
    }

    public IBinder onBind(Intent arg0) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.marley);
        player.setVolume(100, 100);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    public void startPauseMusic() {
        if (player.isPlaying())
            player.pause();
        else {
            player.start();
        }
    }

    public void nextSound() {
        player.stop();
        player = MediaPlayer.create(this, R.raw.acdc);
        player.setVolume(100, 100);
        player.start();
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }


}
