package com.example.firebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mobileSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_sign_in);

        EditText numberCol= findViewById(R.id.number);
        Button sendOtp = findViewById(R.id.sendBtn);


        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!numberCol.getText().toString().trim().isEmpty()){
                    if((numberCol.getText().toString().trim()).length() == 10){
            Intent intent = new Intent(getApplicationContext(), otpVerification.class);
            intent.putExtra("mobile", numberCol.getText().toString());
            startActivity(intent);
                    }else {
                        Toast.makeText(mobileSignIn.this, "please enter correct number", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(mobileSignIn.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }

//                String number = numberCol.getText().toString();
//                if(number.length()<10 && number.length()>1){
//                    Toast.makeText(mobileSignIn.this, "please enter correct number", Toast.LENGTH_SHORT).show();
//                }
//                else if(number.length()==10) {
//                    Intent intent = new Intent(mobileSignIn.this, otpVerification.class);
//                    intent.putExtra("mobile", number);
//                    finish();
//                }
//                else{
//                    Toast.makeText(mobileSignIn.this, "Enter 10 Digit Number", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}