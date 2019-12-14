package ru.belenkov.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ArrayList<String> monthsList = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, monthsList);

        ListView itemList = findViewById(R.id.itemList);
        Button button = findViewById(R.id.button);
        final EditText input = findViewById(R.id.input);

        itemList.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String inputString = input.getText().toString();
                monthsList.add(inputString);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
