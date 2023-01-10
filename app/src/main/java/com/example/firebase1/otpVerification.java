package com.example.firebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class otpVerification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        Button verify = findViewById(R.id.verifyBtn);

        EditText col1 = findViewById(R.id.num1);
        EditText col2 = findViewById(R.id.num2);
        EditText col3 = findViewById(R.id.num3);
        EditText col4 = findViewById(R.id.num4);
        EditText col5 = findViewById(R.id.num5);
        EditText col6 = findViewById(R.id.num6);

        TextView myNum = findViewById(R.id.myNumber);


        myNum.setText(String.format("+91-%s", getIntent().getStringExtra("mobile")));

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!col1.getText().toString().trim().isEmpty() && !col2.getText().toString().trim().isEmpty() && !col3.getText().toString().trim().isEmpty()
                        && !col3.getText().toString().trim().isEmpty() && !col4.getText().toString().trim().isEmpty() && !col5.getText().toString().trim().isEmpty()
                        && !col6.getText().toString().trim().isEmpty()) {
                    Toast.makeText(otpVerification.this, "Otp Verify", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(otpVerification.this, "please enter all number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        moveNumber();
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
}