package com.example.threads;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskDemo2 extends AppCompatActivity {

    TextView loadBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_demo2);

        loadBar = findViewById(R.id.loadBar);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Важное сообщение!")
                        .setMessage("Покормите кота!")
                        .setCancelable(false)
                        .setNegativeButton("ОК, иду на кухню",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        new LoadSomething(loadBar).execute(100);

    }
}


class LoadSomething extends AsyncTask<Integer, String, String> {
    TextView view;

    LoadSomething(TextView view) {
        this.view = view;
        Toast.makeText(view.getContext(), " Создался экземлпляр класса", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(view.getContext(), "Подготовка к выполнению", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected String doInBackground(Integer... integers) {
        int maxLoadCount = integers[0];
        for (int i = 0; i < maxLoadCount; i++) {
            publishProgress("Загружено на " + i + " %");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Полностью загружено!";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        String progress = values[0];
        view.setText(progress);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        view.setText(s);
    }
}

