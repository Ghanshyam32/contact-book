package com.example.firebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class mobileSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_sign_in);

        EditText numberCol = findViewById(R.id.number);
        Button sendOtp = findViewById(R.id.sendBtn);


        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!numberCol.getText().toString().trim().isEmpty()) {
                    if ((numberCol.getText().toString().trim()).length() == 10) {

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + numberCol.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                mobileSignIn.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        Toast.makeText(mobileSignIn.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        super.onCodeSent(s, forceResendingToken);
                                        Intent intent = new Intent(getApplicationContext(), otpVerification.class);
                                        intent.putExtra("mobile", numberCol.getText().toString());
                                        intent.putExtra("backendOtp", s);
                                        startActivity(intent);
                                    }
                                }
                        );
//
                    } else {
                        Toast.makeText(mobileSignIn.this, "please enter correct number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mobileSignIn.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(mobileSignIn.this, Login.class);
        startActivity(intent);
    }
}