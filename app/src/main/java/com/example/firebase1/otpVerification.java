package com.example.firebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otpVerification extends AppCompatActivity {

    private EditText col1;
    private EditText col2;
    private EditText col3;
    private EditText col4;
    private EditText col5;
    private EditText col6;

    private String getOtpBackend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        Button verify = findViewById(R.id.verifyBtn);

        col1 = findViewById(R.id.num1);
        col2 = findViewById(R.id.num2);
        col3 = findViewById(R.id.num3);
        col4 = findViewById(R.id.num4);
        col5 = findViewById(R.id.num5);
        col6 = findViewById(R.id.num6);

        TextView myNum = findViewById(R.id.myNumber);


        myNum.setText(String.format("+91-%s", getIntent().getStringExtra("mobile")));

        getOtpBackend = getIntent().getStringExtra("backendOtp");

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!col1.getText().toString().trim().isEmpty() && !col2.getText().toString().trim().isEmpty() && !col3.getText().toString().trim().isEmpty()
                        && !col3.getText().toString().trim().isEmpty() && !col4.getText().toString().trim().isEmpty() && !col5.getText().toString().trim().isEmpty()
                        && !col6.getText().toString().trim().isEmpty()) {

                    String codeOtp = col1.getText().toString() +
                            col2.getText().toString() +
                            col3.getText().toString() +
                            col4.getText().toString() +
                            col5.getText().toString() +
                            col6.getText().toString();

                    if (getOtpBackend != null) {
                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getOtpBackend, codeOtp);

                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(otpVerification.this, "enter correct otp", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    } else {
                        Toast.makeText(otpVerification.this, "please check internet connection", Toast.LENGTH_SHORT).show();
                    }

//                    Toast.makeText(otpVerification.this, "Otp Verify", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(otpVerification.this, "please enter all number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        moveNumber();

        findViewById(R.id.resendOtp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        TextView resendLabel = findViewById(R.id.resendOtp);
        resendLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        otpVerification.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(otpVerification.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newBackendOtp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(newBackendOtp, forceResendingToken);
                                getOtpBackend = newBackendOtp;
                                Toast.makeText(otpVerification.this, "Otp Send Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        });

    }


    private void moveNumber() {
        col1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    col2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        col2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    col3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        col3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    col4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        col4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    col5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        col5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    col6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(otpVerification.this, mobileSignIn.class);
        startActivity(intent);
    }
}