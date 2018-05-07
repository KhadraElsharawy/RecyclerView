package com.example.basmet.recyclerview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by basmet on 3/31/2018.
 */

public class PersonDBHelper extends SQLiteOpenHelper {
    public static String DATA_BASE_NAME = "person.db";
    public static int Data_Base_Version = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PersonContract.PersonEntry.TABLE_NAME + " (" +
                    PersonContract.PersonEntry._ID + " INTEGER PRIMARY KEY," +
                    PersonContract.PersonEntry.NAME + " TEXT," +
                    PersonContract.PersonEntry.AGE + " INTEGER," +
                    PersonContract.PersonEntry.HEIGHT + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PersonContract.PersonEntry.TABLE_NAME;

    public PersonDBHelper(Context context) {
        super(context,DATA_BASE_NAME, null, Data_Base_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
