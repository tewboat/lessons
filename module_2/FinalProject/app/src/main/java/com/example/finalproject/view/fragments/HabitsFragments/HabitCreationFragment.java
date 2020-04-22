package com.example.finalproject.view.fragments.HabitsFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.R;
import com.example.finalproject.domain.Habit;
import com.example.finalproject.interactor.Interactor;
import com.example.finalproject.view.adapter.HabitsListAdapter;

public class HabitCreationFragment extends Fragment {

    Button cancel;
    Button enter;
    EditText habitName;
    Interactor interactor;

    final HabitsListAdapter habitsListAdapter;
    public HabitCreationFragment(HabitsListAdapter habitsListAdapter, Context context){
        this.habitsListAdapter = habitsListAdapter;
        this.interactor = new Interactor(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.habit_creation_fragment, container, false);

        habitName = view.findViewById(R.id.habit_creation_fragment_habit_name_edit_text);
        cancel = view.findViewById(R.id.habit_creation_fragment_cancel_button);
        enter = view.findViewById(R.id.habit_creation_fragment_enter_button);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setOnClickListeners();
    }

    public void setOnClickListeners(){

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (habitName.getText()!= null && !habitName.getText().toString().equals("")) {
                    Habit habit = new Habit(null, habitName.getText().toString(), 0);
                    habitsListAdapter.addHabit(habit);
                    interactor.insertHabitIntoDb(habit);
                    getActivity().getSupportFragmentManager().popBackStack();

                }
            }
        });
    }
}
