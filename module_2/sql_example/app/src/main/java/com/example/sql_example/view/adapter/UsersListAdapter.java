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

    public void updateUserList(ArrayList<UserProfiles> userProfiles){
        this.userProfilesArrayList = userProfiles;
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
            status = itemView.findViewById(R.id.status_resycler_view_item);
        }

        void bind(UserProfiles userProfile, User user){
            userName.setText(user.name);
            switch (userProfile.isConfirm){
                case 1:
                    status.setText("В списке друзей");
                    firstButton.setBackgroundResource(R.drawable.button_style);
                    secondButton.setBackgroundResource(R.drawable.button_null);
                    firstButton.setText("УДАЛИТЬ");
                    firstButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            usersInteractor.deleteLinkFromDb(user.id, userProfile.id);
                            updateUserList(usersInteractor.getUserList(user.id));
                        }

                    });
                    break;

                case 0:
                    status.setText("Не в списке друзей");
                    firstButton.setBackgroundResource(R.drawable.button_style);
                    secondButton.setBackgroundResource(R.drawable.button_null);
                    firstButton.setText("ДОБАВИТЬ");
                    firstButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            usersInteractor.addLinkIntoDb(user.id, userProfile.id);
                            updateUserList(usersInteractor.getUserList(user.id));
                        }
                    });
                    break;

                case -1:
                    status.setText("У вас новая заявка");
                    firstButton.setBackgroundResource(R.drawable.button_style);
                    secondButton.setBackgroundResource(R.drawable.button_style);
                    firstButton.setText("ДОБАВИТЬ");
                    secondButton.setText("ОТКЛОНИТЬ");
                    firstButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            usersInteractor.updateDb(user.id, userProfile.id);
                            updateUserList(usersInteractor.getUserList(user.id));
                        }
                    });
                    secondButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            usersInteractor.deleteLinkFromDb(user.id, userProfile.id);
                            updateUserList(usersInteractor.getUserList(user.id));
                        }
                    });
                    break;

                case -2:
                    status.setText("Ваша заявка ожидает подтверждения");
                    firstButton.setBackgroundResource(R.drawable.button_null);
                    secondButton.setBackgroundResource(R.drawable.button_null);
                    break;
            }
        }
    }

}
