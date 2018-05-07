package com.example.basmet.recyclerview;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by basmet on 4/4/2018.
 */

public class PeopleFragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    RecyclerView recyclerView;
    PeopleAdapter adapter;
    //make it to be public for all methods to get index of the current item
    List<Person> peopleList = new ArrayList<>();
    ProgressDialog progressDialog;
    private static final String URL_ARG= "peopleurl";
    private String peopleUrl;
    public PeopleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment PeopleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PeopleFragment newInstance(String peopleurl) {
        PeopleFragment fragment = new PeopleFragment();
        Bundle args = new Bundle();
        args.putString(URL_ARG,peopleurl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            peopleUrl = getArguments().getString(URL_ARG);
        }
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("loading......");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.people_fragment, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //List<Person> people = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_view);
        // set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        try {
            URL urls = new URL(peopleUrl);
            MakeAsyncTask makeAsyncTask = new MakeAsyncTask();
            makeAsyncTask.execute(urls);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    private class MakeAsyncTask extends AsyncTask<URL, Void, List<Person>> {
        //////
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (progressDialog != null)
                progressDialog.show();
        }


        @Override
        protected List<Person> doInBackground(URL... urls) {

            List<Person> result = null;
            UserConnection userConnection = new UserConnection();
            try {
                result = userConnection.loadData(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PersonDBHelper personDBHelper = new PersonDBHelper(getContext());

            CURDPerson crudPerson = new CURDPerson(personDBHelper);

            if (result != null) {
                for (int i = 0; i < result.size(); i++) {
                    crudPerson.insert(result.get(i));

                }

            }
            return result;
        }


        @Override
        protected void onPostExecute(List<Person> people) {
            super.onPostExecute(people);
            //////fill my list with data cacheted

            peopleList = people;
            adapter = new PeopleAdapter(getContext(), peopleList);
            //adapter.setClickListener(MainActivity.this);
            recyclerView.setAdapter(adapter);
            //Toast.makeText(MainActivity.this, "" + people.size(), Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();


        }
    }




}
