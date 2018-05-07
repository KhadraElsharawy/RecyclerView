package com.example.basmet.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PersonDetails extends AppCompatActivity {
    private final static String key = "key";


    public  static void openActivity(Context from,Person person){
        Intent intent = new Intent(from, PersonDetails.class);
        intent.putExtra(PersonDetails.key, person.getName());
        intent.putExtra(PersonDetails.key, person.getAge());
        intent.putExtra(PersonDetails.key, person.getHeight());
        from.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        String data = (String) getIntent().getSerializableExtra(key);

    }
}
