package com.example.finalproject.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.finalproject.R;
import com.example.finalproject.view.fragments.GoalsFragments.GoalsFragment;
import com.example.finalproject.view.fragments.HabitsFragments.HabitsFragment;
import com.example.finalproject.view.fragments.TodoFragments.TodoFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    Button diaryFragmentCallingButton, habitsFragmentCallingButton, goalsFragmentCallingButton;
    ArrayList<Fragment> fragmentArrayList;
    int todoFragmentID = 0;
    int habitsFragmentID = 1;
    int goalsFragmentID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnClickListeners();
    }

    private void initView() {
        diaryFragmentCallingButton = findViewById(R.id.todo_fragment_calling_button);
        habitsFragmentCallingButton = findViewById(R.id.habits_fragment_calling_button);
        goalsFragmentCallingButton = findViewById(R.id.goals_fragment_calling_button);

        fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(new TodoFragment(getApplicationContext()));
        fragmentArrayList.add(new HabitsFragment(getApplicationContext()));
        fragmentArrayList.add(new GoalsFragment(getApplicationContext()));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragmentArrayList.get(todoFragmentID)).addToBackStack(null).commit();
    }

    private void setOnClickListeners() {

        diaryFragmentCallingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FRAGMENT", "starting diary fragment");
                fragmentCall(v);

            }
        });

        habitsFragmentCallingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FRAGMENT", "starting habits fragment");
                fragmentCall(v);
            }
        });

        goalsFragmentCallingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FRAGMENT", "starting goals fragment");
                fragmentCall(v);
            }
        });
    }
    private void fragmentCall(View view) {
        Fragment fragment = null;
        Log.d("fragmentChange", "fragmentCall: choosing fragment");
        switch (view.getId()) {
            case R.id.todo_fragment_calling_button:
                fragment = fragmentArrayList.get(todoFragmentID);
                break;
            case R.id.habits_fragment_calling_button:
                fragment = fragmentArrayList.get(habitsFragmentID);
                break;
            case R.id.goals_fragment_calling_button:
                fragment = fragmentArrayList.get(goalsFragmentID);
                break;
        }
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(null).commit();
            Log.d("fragmentChange", "fragmentCall: starting fragment");
        }
    }

}

