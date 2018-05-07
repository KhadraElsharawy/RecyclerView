package com.example.basmet.recyclerview;

import android.provider.BaseColumns;

/**
 * Created by basmet on 3/31/2018.
 */

public class PersonContract {

    private PersonContract(){

    }

    public class PersonEntry implements BaseColumns{
        public static final String TABLE_NAME = "people";
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String HEIGHT = "height";
    }
}
