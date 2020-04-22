package com.example.finalproject.view.fragments.GoalsFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.domain.Goal;
import com.example.finalproject.domain.Step;
import com.example.finalproject.interactor.Interactor;
import com.example.finalproject.view.adapter.StepsListAdapter;

import java.util.ArrayList;

public class StepsFragment extends Fragment {

    Goal goal;
    ArrayList<Step> stepsArrayList;
    Context context;
    Interactor interactor;
    Button addStep;
    TextView goalName;
    RecyclerView recyclerView;

    public StepsFragment(Goal goal, Context context){
        this.goal = goal;
        this.context = context;
        interactor = new Interactor(context);
        stepsArrayList = interactor.getStepsList(goal);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.steps_fragment, container, false);
        addStep = view.findViewById(R.id.add_step);
        goalName = view.findViewById(R.id.goal_text_steps_fragment);
        recyclerView = view.findViewById(R.id.steps_list_recycler_view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView(goal, context);
    }

    private void bindView(Goal goal, Context context){
        goalName.setText(goal.getText());
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        StepsListAdapter stepsListAdapter = new StepsListAdapter(stepsArrayList, context);
        recyclerView.setAdapter(stepsListAdapter);
    }
}
