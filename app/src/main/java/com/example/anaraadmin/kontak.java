package com.example.anaraadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;

public class kontak extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);
        final EditText edit_email = findViewById(R.id.editText_email);
        final EditText edit_message = findViewById(R.id.editText_message);
        final EditText edit_username = findViewById(R.id.editText_username);
        Button btn = findViewById(R.id.btn_kontak);
        Daoanara dao =new Daoanara();
        btn.setOnClickListener(v->
        {
            anarausers ara = new anarausers(edit_email.getText().toString(),edit_message.getText().toString(),edit_username.getText().toString());
                dao.add(ara).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Thank You for Message", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
        });
    }
}