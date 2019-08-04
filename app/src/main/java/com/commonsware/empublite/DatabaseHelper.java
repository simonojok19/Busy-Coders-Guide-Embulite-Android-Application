package com.commonsware.empublite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="empublite.db";
    private static final int SCHEMA_NAME = 1;
    private static DatabaseHelper singleton = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_NAME);
    }

    synchronized static DatabaseHelper getInstance(Context ctxt){
        if (singleton == null){
            singleton = new DatabaseHelper(ctxt.getApplicationContext());
        }

        return singleton;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE notes (position INTEGER PRIMARY KEY, prose TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        throw new RuntimeException("This should not be called");
    }
}
