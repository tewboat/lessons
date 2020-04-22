package com.example.finalproject.view.fragments.GoalsFragments;

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
import com.example.finalproject.domain.Goal;
import com.example.finalproject.interactor.Interactor;
import com.example.finalproject.view.adapter.GoalsListAdapter;

import java.util.ArrayList;

public class GoalsFragment extends Fragment implements GoalsListAdapter.OnGoalClickListener {
    String TAG = "GoalsFragment";
    Button addGoal;
    RecyclerView recyclerView;
    GoalsListAdapter goalsListAdapter;
    Interactor interactor;
    ArrayList<Goal> goalArrayList;
    Context context;

    public GoalsFragment(Context context){
        this.context = context;
    }
        @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Log.d(TAG, "onCreateView: start creating view");
            View view = inflater.inflate(R.layout.goals_fragment, container, false);
            Log.d(TAG, "onCreateView: view created");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        setOnClickListeners();
    }

    private void init(){
        View view = getView();
        interactor = new Interactor(view.getContext());
        goalArrayList = interactor.getGoalsList();
        addGoal = view.findViewById(R.id.add_goal);
        recyclerView = view.findViewById(R.id.goals_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        goalsListAdapter = new GoalsListAdapter(goalArrayList, this);
        recyclerView.setAdapter(goalsListAdapter);
    }

    private void setOnClickListeners(){
        addGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goal goal = new Goal(null, "became a star", "0%");
                goalArrayList.add(goal);
                goalsListAdapter.updateListAdapter(goalArrayList);
                interactor.insertGoalIntoDb(goal);
            }
        });
    }

    @Override
    public void onGoalClick(int position) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new StepsFragment(goalArrayList.get(position),context)).addToBackStack(null).commit();
    }
}
