package ru.belenkov.lists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import ru.belenkov.lists.domain.Contact;

public class RecyclerDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);

        Button back = findViewById(R.id.listviewdemo);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerDemo.this, Main4Activity.class));
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

        RecyclerAdapter contactAdapter = new RecyclerAdapter(contactArrayList);
        RecyclerView contactList = findViewById(R.id.contactRecyclerView);

//        contactList.setLayoutManager(new LinearLayoutManager(this));
        contactList.setLayoutManager(new GridLayoutManager(this, 1));
        contactList.setAdapter(contactAdapter);
    }
}

class RecyclerAdapter extends RecyclerView.Adapter<ContactVH> {
    final ArrayList<Contact> userList;

    public RecyclerAdapter(ArrayList<Contact> userList) {
        this.userList = userList;
    }


    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactVH(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactVH holder, int position) {
        Contact contact = userList.get(position);
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

class ContactVH extends RecyclerView.ViewHolder {

    TextView name;
    TextView phone;
    CircularImageView image;

    public ContactVH(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        phone = itemView.findViewById(R.id.phone);
        image = itemView.findViewById(R.id.avatar);
    }

    public void bind(Contact contact) {
        name.setText(contact.contactName);
        phone.setText(contact.contactPhoneNumber);
        image.setImageResource(contact.avatarUrl);
    }
}
