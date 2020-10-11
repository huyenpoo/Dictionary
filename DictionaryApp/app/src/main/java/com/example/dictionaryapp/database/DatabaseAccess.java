package com.example.dictionaryapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    // Private constructor to aboid object creation from outside classes.
    private DatabaseAccess(Context context, String name) {
        this.openHelper = new DatabaseOpenHelper(context, name);
    }

    //Return a singleton instance of DatabaseAccess.
    public static DatabaseAccess getInstance(Context context, String name) {
        if (instance == null) {
            instance = new DatabaseAccess(context, name);
        }
        return instance;
    }

    //Open the database connection.
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    //Close the database connection.
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    //Read all anh_viet from the database.
    public List<String> getAnhViet() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM anh_viet", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    //Read all viet_anh from the database.
    public List<String> getVietAnh() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM viet_anh", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public String getDefinition(String word) {
        String definition = "";
        Cursor cursor = database.rawQuery("SELECT * FROM anh_viet where word='"+ word +"'", null);
        cursor.moveToFirst();

        definition  = cursor.getString(2);

        cursor.close();
        return definition;
    }

}
