package com.example.finalproject.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.domain.Todo;
import com.example.finalproject.interactor.Interactor;

import java.util.ArrayList;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoListViewHolder> {

    String TAG = "ToDoListAdapter";
    Context context;
    ArrayList<Todo> todoArrayList;

    public ToDoListAdapter(Context context, ArrayList<Todo> todoArrayList) {
        this.context = context;
        this.todoArrayList = todoArrayList;
    }


    public void removeObjFromArray(Todo todo){
        todoArrayList.remove(todo);
        notifyDataSetChanged();
    }

    public void addObjToArray(Todo todo){
        Log.d(TAG, "addObjToArray: object added");
        todoArrayList.add(todo);
        notifyDataSetChanged();
    }

    public ArrayList<Todo> getTodoArrayList(){
        return todoArrayList;
    }

    @NonNull
    @Override
    public ToDoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.todo_list_item, parent, false);
        return new ToDoListViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoListViewHolder holder, int position) {
        final Todo todo = todoArrayList.get(position);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("REMOVE", "start removing object from array");
                removeObjFromArray(todo);
            }
        });
        holder.bind(todo);

    }

    @Override
    public int getItemCount() {
        return todoArrayList.size();
    }

    class ToDoListViewHolder extends RecyclerView.ViewHolder{
        private TextView todoText;
        private ImageButton deleteButton;
        private View isComplete;
        private LinearLayout linearLayout;
        private Interactor interactor;

        public ToDoListViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            todoText = itemView.findViewById(R.id.todo_text);
            deleteButton = itemView.findViewById(R.id.delete_button);
            interactor = new Interactor(context);
            linearLayout = itemView.findViewById(R.id.todo_item_layout);
        }
        void bind(final Todo todo){
            todoText.setText(todo.getText());

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("REMOVE", "start removing object from array");
                    removeObjFromArray(todo);
                    Log.d(TAG, "onClick: object removed");
                    interactor.removeTodoFromDb(todo);

                }
            });
        }
    }
}
