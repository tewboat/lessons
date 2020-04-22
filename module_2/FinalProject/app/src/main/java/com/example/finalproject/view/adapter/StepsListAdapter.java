package com.example.finalproject.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.domain.Step;

import java.util.ArrayList;

public class StepsListAdapter extends RecyclerView.Adapter<StepsListAdapter.StepsListViewHolder> {

    ArrayList<Step> stepsArrayList;
    Context context;

    public StepsListAdapter(ArrayList<Step> stepArrayList, Context context) {
        this.stepsArrayList = stepArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public StepsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.step_list_item, parent, false);
        return new StepsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepsListViewHolder holder, int position) {
        Step step = stepsArrayList.get(position);
        holder.bind(step);
    }

    @Override
    public int getItemCount() {
        return stepsArrayList.size();
    }

    class StepsListViewHolder extends RecyclerView.ViewHolder{

        TextView stepText;

        public StepsListViewHolder(@NonNull View itemView) {
            super(itemView);
            stepText = itemView.findViewById(R.id.step_list_item_text);
        }

        void bind(Step step){
            stepText.setText(step.getText());
        }
    }
}
