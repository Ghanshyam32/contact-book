package com.example.firebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity {

    RecyclerView recyclerView;
    myAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the current user's UID
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();

            // Set up the query to fetch data from the user's "contacts" node
            DatabaseReference contactsRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("contacts");
            FirebaseRecyclerOptions<modelClass> options =
                    new FirebaseRecyclerOptions.Builder<modelClass>()
                            .setQuery(contactsRef, modelClass.class)
                            .build();

            myAdapter = new myAdapter(options);
            recyclerView.setAdapter(myAdapter);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);

        MenuItem item = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processSearch(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void processSearch(String s) {
        // Get the current user's UID
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();

            // Set up the query to fetch data from the user's "contacts" node
            DatabaseReference contactsRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("contacts");
            FirebaseRecyclerOptions<modelClass> options =
                    new FirebaseRecyclerOptions.Builder<modelClass>()
                            .setQuery(contactsRef.orderByChild("name").startAt(s).endAt(s + "\uf8ff"), modelClass.class)
                            .build();

            myAdapter = new myAdapter(options);
            myAdapter.startListening();
            recyclerView.setAdapter(myAdapter);
        }
    }
}
