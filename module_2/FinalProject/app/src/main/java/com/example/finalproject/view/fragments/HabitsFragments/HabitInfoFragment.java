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

public class HabitInfoFragment extends Fragment {

    Button cancel;
    Button enter;
    EditText habitName;
    final Habit habit;
    Context context;
    Interactor interactor;
    HabitsListAdapter habitsListAdapter;

    public HabitInfoFragment(Habit habit, Context context, HabitsListAdapter habitsListAdapter) {
        this.habit = habit;
        this.context = context;
        interactor = new Interactor(context);
        this.habitsListAdapter = habitsListAdapter;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.habit_info, container, false);

        habitName = view.findViewById(R.id.habit_info_fragment_habit_name_text_view);
        cancel = view.findViewById(R.id.habit_info_fragment_cancel_button);
        enter = view.findViewById(R.id.habit_info_fragment_enter_button);
        setValues();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setOnClickListeners();
    }

    private void setValues() {
        habitName.setText(habit.getText());
    }

    private void setOnClickListeners() {

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (habitName.getText() != null && !habitName.getText().toString().equals("")) {
                    updateHabit();
                    interactor.updateHabitsDb(habit);
                    getActivity().getSupportFragmentManager().popBackStack();

                }
            }
        });
    }

    private void updateHabit(){
        habit.updateText(habitName.getText().toString());
    }
}

