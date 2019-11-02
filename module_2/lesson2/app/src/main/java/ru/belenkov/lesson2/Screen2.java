package ru.belenkov.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {

    String greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);

        init();

        Toast.makeText(this, greeting, Toast.LENGTH_SHORT).show();
    }

    private void init() {
        greeting = getIntent().getStringExtra("greeting");
    }
}
