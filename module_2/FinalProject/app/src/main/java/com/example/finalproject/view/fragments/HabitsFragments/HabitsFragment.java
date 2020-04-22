package com.example.finalproject.view.fragments.HabitsFragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.domain.Habit;
import com.example.finalproject.interactor.Interactor;
import com.example.finalproject.view.adapter.HabitsListAdapter;

public class HabitsFragment extends Fragment implements HabitsListAdapter.OnHabitClick {

    private Button addHabit;
    private RecyclerView recyclerView;
    private Interactor interactor;
    private HabitsListAdapter habitsListAdapter;
    private Context context;
    private String TAG = "HabitsFragment";

    public HabitsFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("FRAGMENT", "onCreateView: creating fragment");
        View view = inflater.inflate(R.layout.habits_fragment, container, false);
        addHabit = view.findViewById(R.id.add_habit);
        recyclerView = view.findViewById(R.id.habits_list_recycler_view);
        Log.d(TAG, "onCreateView: view created");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        setOnClickListeners();
    }

    private void init() {
        Context context = getView().getContext();
        interactor = new Interactor(context);
        habitsListAdapter = new HabitsListAdapter(interactor.getHabitsList(), context, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(habitsListAdapter);
    }

    private void setOnClickListeners() {
        addHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HabitCreationFragment(habitsListAdapter, context)).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public void onClick(int position) {
        Habit habit = habitsListAdapter.getHabitArrayList().get(position);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new HabitInfoFragment(habit, context, habitsListAdapter)).addToBackStack(null).commit();
    }
}
