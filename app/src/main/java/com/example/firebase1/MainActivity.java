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

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logging You out..", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, StartActivity.class));
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ContactsList.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
//                    FirebaseDatabase.getInstance().getReference().child("Ghanshyam Mishra").child("Multiple").up(map);
//                    FirebaseDatabase.getInstance().getReference().child("Ghanshyam").push().child("Number").setValue(txt_number);

                }
            }
        });


//        FirebaseDatabase.getInstance().getReference().child("Ghanshyam Mishra").child("Android").setValue("Moto G5s Plus");
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("Name", txt_);
//        map.put("Email", "ghanshyammishra3205615@gmail.com");
//
//        FirebaseDatabase.getInstance().getReference().child("Ghanshyam Mishra").child("Multiple").updateChildren(map);
    }
    }