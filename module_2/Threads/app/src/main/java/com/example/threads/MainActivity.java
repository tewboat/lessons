package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Random;

import static com.example.threads.MainActivity.TAG;


public class MainActivity extends AppCompatActivity {

    static final String TAG = "THREAD_DEMO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threadReadDemo();
    }

    private void threadReadDemo() {
        String randString = generateRandStroke(100);
        long startTime = System.currentTimeMillis();
        StrokeReader strokeReader = new StrokeReader(0, 50, randString);
        StrokeReader strokeReader1 = new StrokeReader(50, 10, randString);
        strokeReader.start();
        strokeReader1.start();
        try {
            strokeReader.join();
            strokeReader1.join();
            long endTime = System.currentTimeMillis();
            Log.d(TAG, "время считывания данных: " + ((endTime - startTime) / 1000) + " секунд");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private String generateRandStroke(int strokeSize) {
        String reference = "123456789qwertyuiopasdfghjklzxcvbnm";
        Random rand = new Random();
        StringBuilder generatedStroke = new StringBuilder();
        for (int i = 0; i < strokeSize; i++) {
            char randChar = reference.charAt(rand.nextInt(reference.length()));
            generatedStroke.append(randChar);
        }

        return generatedStroke.toString();
    }
}

class StrokeReader extends Thread {
    final int startIndex;
    final int endIndex;
    final String text;

    public StrokeReader(int startIndex, int endIndex, String text) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.text = text;
    }

    @Override
    public void run() {
        String stroke = "";
        for (int i = startIndex; i < endIndex; i++) {
            stroke += text.charAt(i);
            Log.d(TAG, stroke);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

