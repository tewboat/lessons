package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.concurrent.TimeUnit;

public class AmazingService extends Service {
    Thread testThread;
    int startId;

    public AmazingService() {
        testThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    Log.d("SERVICE", "i = " + i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stop();
            }

            void stop() {
                Log.d(LOG_TAG, "MyRun#" + startId + " end, stopSelfResult("
                        + startId + ") = " + stopSelfResult(startId));
            }
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
        this.startId = startId;
        String message = intent.getStringExtra("INTENT_MESSAGE");
        Log.d(LOG_TAG, "recieved message " + message);
        someTask();
        return START_NOT_STICKY;
    }


    public void onDestroy() {
        testThread.interrupt();
        super.onDestroy();

        Log.d(LOG_TAG, "onDestroy");
    }


    void someTask() {
        testThread.start();
    }
}
