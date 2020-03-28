package com.example.sql_example.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sql_example.R;
import com.example.sql_example.domain.User;
import com.example.sql_example.domain.UserProfiles;
import com.example.sql_example.interactor.UsersInteractor;

import java.util.ArrayList;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UsersListViewHolder> {

    ArrayList<UserProfiles> userProfilesArrayList;
    User user;
    UsersInteractor usersInteractor;
    public UsersListAdapter(ArrayList<UserProfiles> incomeUserProfilesArrayList, User user){
        this.userProfilesArrayList = incomeUserProfilesArrayList;
        this.user = user;
    }

    public void updateUserList(UsersInteractor usersInteractor, int userID){
        userProfilesArrayList = usersInteractor.getUserProfilesList(userID);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        usersInteractor = new UsersInteractor(parent.getContext());
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_recycler_view_item, parent, false);
        return new UsersListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersListViewHolder holder, int position) {
        UserProfiles userProfile = userProfilesArrayList.get(position);
        holder.bind(userProfile, user);
    }

    @Override
    public int getItemCount() {
        return userProfilesArrayList.size();
    }

    class UsersListViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        Button firstButton;
        Button secondButton;
        TextView status;
        public UsersListViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name_recycler_view_item);
            firstButton = itemView.findViewById(R.id.image_button1_recycler_view_item);
            secondButton = itemView.findViewById(R.id.image_button2_recycler_view_item);
        }

        void bind(UserProfiles userProfile, User user){
            userName.setText(userProfile.name);
            switch (userProfile.isConfirm){
                case 1:
                    firstButton.setBackgroundResource(R.drawable.button_style);
                    secondButton.setBackgroundResource(R.drawable.button_null);
                    firstButton.setText("УДАЛИТЬ");
                    firstButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            usersInteractor.deleteLinkFromDb(user.id, userProfile.id);
                            updateUserList(usersInteractor, user.id);
                        }

                    });
                    break;

                case 0:
                    firstButton.setBackgroundResource(R.drawable.button_style);
                    secondButton.setBackgroundResource(R.drawable.button_null);
                    firstButton.setText("ДОБАВИТЬ");
                    firstButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            usersInteractor.addLinkIntoDb(user.id, userProfile.id, -1);
                            updateUserList(usersInteractor, user.id);
                        }
                    });
                    break;

                case -1:
                    firstButton.setBackgroundResource(R.drawable.button_style);
                    secondButton.setBackgroundResource(R.drawable.button_style);
                    firstButton.setText("ДОБАВИТЬ");
                    secondButton.setText("ОТКЛОНИТЬ");
                    firstButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            usersInteractor.updateDb(user.id, userProfile.id);
                            updateUserList(usersInteractor, user.id);
                        }
                    });
                    secondButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            secondButton.setText("");
                            usersInteractor.deleteLinkFromDb(user.id, userProfile.id);
                            updateUserList(usersInteractor, user.id);
                        }
                    });
                    break;

                case -2:
                    firstButton.setBackgroundResource(R.drawable.button_null);
                    firstButton.setText("Ожидание");
                    secondButton.setBackgroundResource(R.drawable.button_null);
                    break;
            }
        }
    }

}
