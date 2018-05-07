package com.example.basmet.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by basmet on 3/23/2018.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {


    private Context context;

    private List<Person> arrayPerson = new ArrayList<>();

    PersonAdapter(Context context, List<Person> arrayPerson) {
        this.arrayPerson = arrayPerson;
        this.context =context;
    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View items = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        ViewHolder viewHolder;
        viewHolder = new ViewHolder(items);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder holder, int position) {
        Person person = arrayPerson.get(position);
        holder.textView.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return arrayPerson.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        ViewHolder(View itemview) {
            super(itemview);
            textView = itemview.findViewById(R.id.text_view);
            itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "hello", Toast.LENGTH_LONG).show();
           //  PersonDetails.openActivity(context,arrayPerson.get(getPosition()));
        }
    }

}
