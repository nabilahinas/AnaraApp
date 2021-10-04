package com.example.anaraadmin;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Daoanara
{
    private DatabaseReference databaseReference;
    public Daoanara()
    {
        FirebaseDatabase db =FirebaseDatabase.getInstance();
        databaseReference = db.getReference(anarausers.class.getSimpleName());
    }
    public Task<Void> add(anarausers ara)
    {
        return databaseReference.push().setValue(ara);
    }
}
