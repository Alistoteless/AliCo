package com.ali.denemeson;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ali on 3/2/2017.
 */
public class DBHelper extends SQLiteOpenHelper {
    //version number to upgrade database version
    //each time if you Add, Edit table, you need to change the
    //version number.
    private static final int DATABASE_VERSION = 11;

    // Database Name
    private static final String DATABASE_NAME = "elipsoit.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_ELIPSOIT = "CREATE TABLE " + Elipsoit.TABLE  + "("
                + Elipsoit.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Elipsoit.KEY_NAME + " TEXT, "
                + Elipsoit.KEY_A + " VARCHAR, "
                + Elipsoit.KEY_B + " VARCHAR )";

        db.execSQL(CREATE_TABLE_ELIPSOIT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Elipsoit.TABLE);


        // Create tables again
        onCreate(db);


    }
}
