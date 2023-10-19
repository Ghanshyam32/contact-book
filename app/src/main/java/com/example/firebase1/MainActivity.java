package com.example.firebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button logout;
    private EditText name;
    private EditText number;
    private Button add;
    private Button show;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.btnLogout);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        add = findViewById(R.id.add);
        show = findViewById(R.id.show);

        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(MainActivity.this, "Logging You out..", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, StartActivity.class));
            finish();
        });

        show.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ContactsList.class)));

        add.setOnClickListener(v -> {
            String txt_name = name.getText().toString();
            String txt_number = number.getText().toString();

            if (TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_number)) {
                Toast.makeText(MainActivity.this, "No details Entered!", Toast.LENGTH_SHORT).show();
            } else {

                HashMap<String, Object> map = new HashMap<>();
                map.put("name", txt_name);
                map.put("number", txt_number);
                Toast.makeText(MainActivity.this, "Contact Saved", Toast.LENGTH_SHORT).show();

                FirebaseDatabase.getInstance().getReference().child("Ghanshyam").push().setValue(map);
            }
        });

    }

    @Override
    public void onBackPressed() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            super.onBackPressed(); // Close the app
        } else {
            Toast.makeText(this, "Please log out before exiting the app", Toast.LENGTH_SHORT).show();
        }
    }
}