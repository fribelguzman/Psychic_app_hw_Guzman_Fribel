package com.example.psychic_app_hw_guzman_fribel.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GuessData extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "Choices";
    private static final String DATABASE_NAME = "choices.db";
    private static final int SCHEMA_VERSION = 1;



    public GuessData( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,  "choices.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, guesses INTEGER, guessed_right INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addChoice(GuessModel guesses) {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE name = '" + guesses.getchosen() +
                "' AND guesses = '" + guesses.getGuessedWrong() +
                "' AND guesses_right = '" + guesses.getGuessedRight() +
                "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, guesses, guesses_right) " +
                    "VALUES('" + guesses.getchosen() + "', '" +
                    guesses.getGuessedWrong() + "', '" +
                    guesses.getGuessedRight() + "');");
        }
        cursor.close();
    }

}
