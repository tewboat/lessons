package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.interactor.CarsInteractor;
import com.example.myapplication.view.adapter.CarsAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView carsRecycler;
    private CarsAdapter carsAdapter;
    private CarsInteractor carsInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carsInteractor = new CarsInteractor();
        carsRecycler = findViewById(R.id.carsRecycler);
        carsRecycler.setLayoutManager(new LinearLayoutManager(this));
        carsAdapter = new CarsAdapter(carsInteractor.getCars());
        carsRecycler.setAdapter(carsAdapter);
    }

}
