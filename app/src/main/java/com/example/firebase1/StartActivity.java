package com.example.firebase1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class StartActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        LinearLayout register = findViewById(R.id.newUser);
        LinearLayout login = findViewById(R.id.oldUser);

        // Check if the user is already logged in
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startMainActivity();
        }

        // Set click listeners for registration and login
        findViewById(R.id.newUser).setOnClickListener(v -> startRegisterActivity());
        findViewById(R.id.oldUser).setOnClickListener(v -> startLoginActivity());
    }

    private void startRegisterActivity() {
        Intent intent = new Intent(StartActivity.this, Register.class);
        startActivity(intent);
        finish();
    }

    private void startLoginActivity() {
        Intent intent = new Intent(StartActivity.this, Login.class);
        startActivity(intent);
        finish();
    }

    private void startMainActivity() {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
