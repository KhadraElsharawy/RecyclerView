package com.example.basmet.recyclerview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = PeopleFragment.newInstance("http://demo7261611.mockable.io/people");
        Fragment fragment2 = PeopleFragment.newInstance("http://demo7261611.mockable.io/people2");
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_people1,fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_people2,fragment2).commit();



    }

    /*@Override
    public void onItemClick(View view, int position) {
        Intent open = new Intent(this, Detailed_Activity.class);
        open.putExtra("key", peopleList.get(position));
        startActivity(open);*/
}

//////Async task to avoid mainthread problem



