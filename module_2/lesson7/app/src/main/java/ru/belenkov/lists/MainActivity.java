package ru.belenkov.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listview);
        final EditText input = findViewById(R.id.input);
        final Button calculate = findViewById(R.id.calculate);


        final ArrayList<String> list = new ArrayList<>();


        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);

        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String result = calculate(input.getText().toString());
                list.add(result);
                adapter.notifyDataSetChanged();
            }
        });
    }

    String calculate(String input) {
        input = input.replace(" ", "");

        StringBuilder parsedInteger = new StringBuilder();
        String operator = "";
        int aggregate = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                parsedInteger.append(c);
            }
            if (!Character.isDigit(c) || i == input.length() - 1) {
                int parsed = Integer.parseInt(parsedInteger.toString());
                if (operator.equals("")) {
                    aggregate = parsed;
                } else {
                    if (operator.equals("+")) {
                        aggregate += parsed;
                    } else if (operator.equals("-")) {
                        aggregate -= parsed;
                    }
                }

                parsedInteger = new StringBuilder();
                operator = "" + c;
            }
        }
        return input + " = " + aggregate;
    }

}
