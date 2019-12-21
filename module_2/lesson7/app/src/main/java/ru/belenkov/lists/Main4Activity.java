package ru.belenkov.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import ru.belenkov.lists.domain.Contact;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button forward = findViewById(R.id.recyclerdemo);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main4Activity.this, RecyclerDemo.class));
            }
        });

        ArrayList<Contact> contactArrayList = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            contactArrayList.add(new Contact("Иван Иванович", "+7 (932)-603-27-27", R.raw.ivan));
            contactArrayList.add(new Contact("John Doe", "+7 (932)-603-27-27", R.raw.doe));
            contactArrayList.add(new Contact("mister Anderson", "+7 (932)-603-27-27", R.raw.neo));
            contactArrayList.add(new Contact("mister Pu", "+7 (932)-603-27-27", R.raw.pu));
            contactArrayList.add(new Contact("Adolf Hitler", "+7 (932)-603-27-27", R.raw.hit));
            contactArrayList.add(new Contact("Al Capone", "+7 (932)-603-27-27", R.raw.capone));
            contactArrayList.add(new Contact("Dart Vader", "+7 (932)-603-27-27", R.raw.vader));
            contactArrayList.add(new Contact("Che Gevara", "+7 (932)-603-27-27", R.raw.che));
            contactArrayList.add(new Contact("Nartuo Uzumaki", "+7 (932)-603-27-27", R.raw.naruto));
            contactArrayList.add(new Contact("Saske Uchiha", "+7 (932)-603-27-27", R.raw.saske));
            contactArrayList.add(new Contact("Artes", "+7 (932)-603-27-27", R.raw.artes));
        }
        ContactAdapter contactAdapter = new ContactAdapter(this, contactArrayList);
        ListView contactList = findViewById(R.id.contactList);
        contactList.setDivider(null);
        contactList.setAdapter(contactAdapter);


    }
}

class ContactAdapter extends ArrayAdapter<Contact> {

    private final Activity context;
    private final ArrayList<Contact> userList;

    public ContactAdapter(Activity context, ArrayList<Contact> userList) {
        super(context, R.layout.contact_item, userList);

        this.context = context;
        this.userList = userList;

    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View contactView = inflater.inflate(R.layout.contact_item, null, false);

        TextView name = contactView.findViewById(R.id.name);
        TextView phone = contactView.findViewById(R.id.phone);
        CircularImageView image = contactView.findViewById(R.id.avatar);

        name.setText(userList.get(position).contactName);
        phone.setText(userList.get(position).contactPhoneNumber);
        image.setImageResource(userList.get(position).avatarUrl);

        return contactView;
    }
}
