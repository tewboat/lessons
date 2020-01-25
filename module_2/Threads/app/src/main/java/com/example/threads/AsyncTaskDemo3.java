package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AsyncTaskDemo3 extends AppCompatActivity {

    Button dialogButton;
    TextView progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_demo3);

        dialogButton = findViewById(R.id.dialogButton);
        progressBar = findViewById(R.id.progressBar);

        new ProgressBarTask(progressBar).execute(100);

        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getLocalizedMessage());
        }
        keyGen.init(256); // for example
        SecretKey secretKey = keyGen.generateKey();
        System.out.println("ключ АЕС " + secretKey.getEncoded());

    }
}


class ProgressBarTask extends AsyncTask<Integer, String, String> {

    TextView progressBar;

    ProgressBarTask(TextView progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(Integer[] objects) {
        int maxCount = objects[0];
        for (int i = 0; i < maxCount; i++) {
            publishProgress("Загружено на " + i + " %");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Загрузка завершена!";
    }

    @Override
    protected void onProgressUpdate(String[] values) {
        super.onProgressUpdate(values);
        progressBar.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String o) {
        super.onPostExecute(o);
        progressBar.setText(o);
    }
}
