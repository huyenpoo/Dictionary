package com.example.dictionaryapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseOpenHelper  extends SQLiteAssetHelper {
    private static final  int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context, String name) {
        super(context, name, null, DATABASE_VERSION);
    }
}
