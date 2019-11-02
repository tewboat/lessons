package ru.belenkov.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Screen1 extends AppCompatActivity {

    private final String TAG = "MAIN_ACTIVITY";

    private Button goToSecondScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1);

        Log.d(TAG, "on create");
        initUI();
        initListeners();
    }

    private void initUI() {
        goToSecondScreenButton = findViewById(R.id.goToSecondScreenButton);
    }

    private void initListeners() {
        goToSecondScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Screen1.this, Screen2.class);
                intent.putExtra("greeting", "Hello from screen 1");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "on resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on destroy");
    }
}
