package com.example.finalproject.view.fragments.TodoFragments;

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
import com.example.finalproject.domain.Todo;
import com.example.finalproject.interactor.Interactor;
import com.example.finalproject.view.adapter.ToDoListAdapter;
import com.example.finalproject.view.fragments.TodoFragments.TodoCreationFragment;

import java.util.ArrayList;

public class TodoFragment extends Fragment {

    Context context;

    public TodoFragment(Context context) {
        this.context = context;
    }

    final String TAG = "TodoFragment";
    Button addTodo;
    RecyclerView recyclerView;
    ArrayList<Todo> todoArrayList;
    Interactor interactor;
    ToDoListAdapter toDoListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todo_fragment, container, false);
        recyclerView = view.findViewById(R.id.todo_list);
        addTodo = view.findViewById(R.id.add_note);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        setOnClickListener();
    }

    private void init(){
        View view = getView();
        interactor = new Interactor(view.getContext());
        Log.d(TAG, "init: getting todoArrayList");
        todoArrayList = interactor.getTodoList();
        Log.d(TAG, "init: todoArrayList successfully got");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        toDoListAdapter = new ToDoListAdapter(getContext(), todoArrayList);
        recyclerView.setAdapter(toDoListAdapter);
    }

    private void setOnClickListener(){
        addTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new TodoCreationFragment(context, toDoListAdapter)).addToBackStack(null).commit();
            }
        });
    }
}
