package com.example.basmet.recyclerview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by basmet on 3/31/2018.
 */

public class CURDPerson {
    private PersonDBHelper personDBHelper;
    public CURDPerson(PersonDBHelper personDBHelper){
        this.personDBHelper = personDBHelper;
    }
    public void insert(Person person){
        SQLiteDatabase sqLiteOpenHelper = personDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PersonContract.PersonEntry.NAME, person.getName());
        values.put(PersonContract.PersonEntry.AGE, person.getAge());
        values.put(PersonContract.PersonEntry.HEIGHT, person.getHeight());
        sqLiteOpenHelper.insert(PersonContract.PersonEntry.TABLE_NAME, null, values);
        Log.v("insert", "insert");
    }

    public List<Person> read(){
        SQLiteDatabase sqLiteDatabase = personDBHelper.getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                PersonContract.PersonEntry.NAME,
                PersonContract.PersonEntry.AGE,
                PersonContract.PersonEntry.HEIGHT
        };
        String sortOrder =
                PersonContract.PersonEntry.NAME + " DESC";
        Cursor cursor = sqLiteDatabase.query(
                PersonContract.PersonEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List<Person> personList = new ArrayList<>();
        while(cursor.moveToNext()) {
            int nameIndex = cursor.getColumnIndex(PersonContract.PersonEntry.NAME);
            String name = cursor.getString(nameIndex);
            int ageIndex = cursor.getColumnIndex(PersonContract.PersonEntry.AGE);
            int age = cursor.getInt(ageIndex);
            int heightIndex = cursor.getColumnIndex(PersonContract.PersonEntry.HEIGHT);
            int height = cursor.getInt(heightIndex);
            Person person = new Person(name, age, height);
            personList.add(person);
        }
        cursor.close();
        return personList;
    }
}
