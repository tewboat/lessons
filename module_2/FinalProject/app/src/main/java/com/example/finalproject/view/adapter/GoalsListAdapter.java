package com.example.finalproject.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.domain.Goal;

import java.util.ArrayList;

public class GoalsListAdapter extends RecyclerView.Adapter<GoalsListAdapter.GoalsListViewHolder> {

    private ArrayList<Goal> goalArrayList;
    private OnGoalClickListener onGoalClickListener;

    public GoalsListAdapter(ArrayList<Goal> goals, OnGoalClickListener onGoalClickListener){
        this.goalArrayList = goals;
        this.onGoalClickListener = onGoalClickListener;
    }

    public void updateListAdapter(ArrayList<Goal> goalArrayList){
        this.goalArrayList = goalArrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GoalsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.goal_list_item, parent, false);
        return new GoalsListViewHolder(view, onGoalClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GoalsListViewHolder holder, int position) {
        Goal goal = goalArrayList.get(position);
        holder.bind(goal);
    }

    @Override
    public int getItemCount() {
        return goalArrayList.size();
    }

    class GoalsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView goalText;
        TextView goalProgress;
        OnGoalClickListener onGoalClickListener;

        public GoalsListViewHolder(@NonNull View itemView, OnGoalClickListener onGoalClickListener) {
            super(itemView);
            this.goalText = itemView.findViewById(R.id.goal_text);
            this.goalProgress = itemView.findViewById(R.id.goal_progress);
            this.onGoalClickListener = onGoalClickListener;

            itemView.setOnClickListener(this);
        }

        void bind(Goal goal){
            goalText.setText(goal.getText());
            goalProgress.setText(goal.getProgress());
        }

        @Override
        public void onClick(View v) {
            onGoalClickListener.onGoalClick(getAdapterPosition());
        }
    }

    public interface OnGoalClickListener{
        void onGoalClick(int position);
    }
}
