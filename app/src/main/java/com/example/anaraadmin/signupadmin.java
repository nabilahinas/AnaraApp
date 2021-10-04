package com.example.anaraadmin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupadmin extends AppCompatActivity {

    EditText SignUpemail,password;
    LinearLayout SignUpButton;
    private FirebaseAuth auth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupadmin);

        SignUpemail = findViewById(R.id.email);
        password = findViewById(R.id.password);
        auth=FirebaseAuth.getInstance();
        SignUpButton = (LinearLayout) findViewById(R.id.btn_signup);

        SignUpButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String email = SignUpemail.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Please enter your E-mail address",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();
                }
                if (pass.length() == 0){
                    Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();
                }
                if (pass.length()<8){
                    Toast.makeText(getApplicationContext(),"Password must be more than 8 digit",Toast.LENGTH_LONG).show();
                }
                else{
                    auth.createUserWithEmailAndPassword(email,pass)
                            .addOnCompleteListener(signupadmin.this, new OnCompleteListener<AuthResult>() {
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(signupadmin.this, "ERROR",Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        startActivity(new Intent(signupadmin.this, MainActivity.class));
                                        finish();
                                    }
                                }
                            });}
            }
        });
    }

    public void navigate_login(View v){
        Intent inent = new Intent(this, loginadmin.class);
        startActivity(inent);
    }
}