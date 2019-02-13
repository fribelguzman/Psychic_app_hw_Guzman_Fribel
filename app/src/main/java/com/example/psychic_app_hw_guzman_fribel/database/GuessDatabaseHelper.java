package com.example.psychic_app_hw_guzman_fribel.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GuessDatabaseHelper extends SQLiteOpenHelper {
    private static GuessDatabaseHelper instance;
    private static final String TABLE_NAME = "Choices";
    private static final String DATABASE_NAME = "choices.db";
    //every time the table changes the version needs to be updated
    private static final int SCHEMA_VERSION = 3;

    public static GuessDatabaseHelper getInstance(Context context) {
        if (instance != null) {
            return instance;
        }

        instance = new GuessDatabaseHelper(context);
        return instance;
    }

    private GuessDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "guess INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //when adding to a DB you dont need to call getReadableDatabase
    public void addChoice(GuessModel guesses) {
        getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                "(guess) " +
                "VALUES('" + guesses.guess() + "');");
    }

    public int getTotalGuesses() {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getAmountCorrect() {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE guess = 1" + ";", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getAmountWrong() {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE guess = 0" + ";", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //here's a helper method to ge the percentage of correct choices. This should be formatted to display properly but I skipped that part.
    public double calculatePercentage() {
        return ((double) getAmountCorrect()) / ((double) getTotalGuesses());
    }
}
