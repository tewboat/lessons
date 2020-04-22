package com.example.finalproject.view.fragments.TodoFragments;

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
import com.example.finalproject.domain.Todo;
import com.example.finalproject.interactor.Interactor;
import com.example.finalproject.view.adapter.ToDoListAdapter;

public class TodoCreationFragment extends Fragment {

    Button cancel;
    Button enter;
    EditText todoName;

    Context context;
    final ToDoListAdapter toDoListAdapter;
    Interactor interactor;

    public TodoCreationFragment(Context context, ToDoListAdapter toDoListAdapter) {
        this.context = context;
        this.toDoListAdapter = toDoListAdapter;
        this.interactor = new Interactor(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todo_creation_fragment, container, false);

        cancel = view.findViewById(R.id.todo_creation_fragment_cancel_button);
        enter = view.findViewById(R.id.todo_creation_fragment_enter_button);
        todoName = view.findViewById(R.id.todo_creation_fragment_habit_name_edit_text);

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
                if(todoName.getText()!= null && !todoName.getText().toString().equals("")){
                    Todo todo = new Todo(null, todoName.getText().toString(), 0, null);
                    toDoListAdapter.addObjToArray(todo);
                    interactor.insertTodoIntoDb(todo);
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
    }
}
