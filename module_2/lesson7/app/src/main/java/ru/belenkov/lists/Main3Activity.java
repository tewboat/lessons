package ru.belenkov.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ArrayList<User> userList = new ArrayList();
        userList.add(new User("Иван Иванович", "+7 (932)-603-27-27", R.raw.ivan));
        userList.add(new User("John Doe", "+7 (932)-603-27-27", R.raw.doe));
        userList.add(new User("mister Anderson", "+7 (932)-603-27-27", R.raw.neo));
        userList.add(new User("mister Pu", "+7 (932)-603-27-27", R.raw.pu));
        userList.add(new User("Adolf Hitler", "+7 (932)-603-27-27", R.raw.hit));
        userList.add(new User("Al Capone", "+7 (932)-603-27-27", R.raw.capone));
        userList.add(new User("Dart Vader", "+7 (932)-603-27-27", R.raw.vader));
        userList.add(new User("Che Gevara", "+7 (932)-603-27-27", R.raw.che));
        userList.add(new User("Nartuo Uzumaki", "+7 (932)-603-27-27", R.raw.naruto));
        userList.add(new User("Saske Uchiha", "+7 (932)-603-27-27", R.raw.saske));
        userList.add(new User("Artes", "+7 (932)-603-27-27", R.raw.artes));

        ListView contactList = findViewById(R.id.contacts);
        contactList.setDivider(null);
        contactList.setAdapter(new MyListAdapter(this, userList));
    }
}

class User {
    String name;
    String phone;
    int avatarUrl;

    public User(String name, String phone, int avatarUrl) {
        this.name = name;
        this.phone = phone;
        this.avatarUrl = avatarUrl;
    }
}

class MyListAdapter extends ArrayAdapter<User> {

    private final Activity context;
    private final ArrayList<User> userList;

    public MyListAdapter(Activity context, ArrayList<User> userList) {
        super(context, R.layout.contact_item, userList);

        this.context = context;
        this.userList = userList;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.contact_item, null, false);

        TextView name = rowView.findViewById(R.id.name);
        TextView phone = rowView.findViewById(R.id.phone);
        CircularImageView image = rowView.findViewById(R.id.avatar);

        name.setText(userList.get(position).name);
        phone.setText(userList.get(position).phone);
        image.setImageResource(userList.get(position).avatarUrl);

        return rowView;

    }
}
