package com.example.anaraadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_desc = findViewById(R.id.edit_desc);
        final EditText edit_ing = findViewById(R.id.edit_ing);
        final EditText edit_name = findViewById(R.id.edit_name);
        Button btn_web = findViewById(R.id.btn_web);
        btn_web.setOnClickListener(v ->
        {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://demo4sc4.appspot.com/food/html/index.html"));
            startActivity(browserIntent);
        });
        Button btn = findViewById(R.id.btn_submit);
        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, RVActivity.class);
            startActivity(intent);
        });
        DAOEmployee dao =new DAOEmployee();
        recipes rcp_edit =(recipes) getIntent().getSerializableExtra("EDIT");
        if (rcp_edit !=null)
        {
            btn.setText("UPDATE");
            edit_desc.setText(rcp_edit.getDescription());
            edit_ing.setText(rcp_edit.getIngredients());
            edit_name.setText(rcp_edit.getUsername());
            btn_open.setVisibility(View.GONE);
        }
        else
        {
            btn.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);
        }
        btn.setOnClickListener(v->
        {
            recipes rcp = new recipes(edit_desc.getText().toString(),edit_ing.getText().toString(),edit_name.getText().toString());
            if (rcp_edit==null) {
                dao.add(rcp).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Recipes is inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception er) {
                        Toast.makeText(MainActivity.this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else
                {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("Description", edit_desc.getText().toString());
                    hashMap.put("Ingredients", edit_desc.getText().toString());
                    hashMap.put("Name", edit_name.getText().toString());
                    dao.update(rcp_edit.getKey(), hashMap).addOnSuccessListener(suc ->
                    {
                        Toast.makeText(this, "Recipes is updated", Toast.LENGTH_SHORT).show();
                        finish();
                    }).addOnFailureListener(er ->
                    {
                        Toast.makeText( this, "" +er.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                }
        });

    }
    public void navigate_web(View v){
        Intent inent = new Intent(this, web.class);
        startActivity(inent);
    }
}