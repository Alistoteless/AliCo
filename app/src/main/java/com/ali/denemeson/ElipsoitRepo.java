package com.ali.denemeson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ali on 3/2/2017.
 */
public class ElipsoitRepo {
    private DBHelper dbHelper;
    ElipsoitRepo(Context context){
        dbHelper = new DBHelper(context);
    }
    public int insert(Elipsoit elipsoit) {
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Elipsoit.KEY_NAME, elipsoit.name);
        values.put(Elipsoit.KEY_A,elipsoit.a);
        values.put(Elipsoit.KEY_B, elipsoit.b);
        long elipsoit_Id = db.insert(Elipsoit.TABLE, null, values);
        db.close();
        return (int) elipsoit_Id;
    }
    public void delete(int elipsoit_ID) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Elipsoit.TABLE, Elipsoit.KEY_ID + "= ?", new String[] { String.valueOf(elipsoit_ID) });
        db.close();
    }
    public ArrayList<HashMap<String, String>> getStudentList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Elipsoit.KEY_ID + "," +
                Elipsoit.KEY_NAME + "," +
                Elipsoit.KEY_A + "," +
                Elipsoit.KEY_B +
                " FROM " + Elipsoit.TABLE;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> elipsoitList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> elipsoit= new HashMap<>();
                elipsoit.put("id", cursor.getString(cursor.getColumnIndex(Elipsoit.KEY_ID)));
                elipsoit.put("name", cursor.getString(cursor.getColumnIndex(Elipsoit.KEY_NAME)));
                elipsoit.put("a", cursor.getString(cursor.getColumnIndex(Elipsoit.KEY_A)));
                elipsoit.put("b", cursor.getString(cursor.getColumnIndex(Elipsoit.KEY_B)));
                elipsoitList.add(elipsoit);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return elipsoitList;

    }
}
