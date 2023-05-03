package com.example.easy_chemistry;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Question.class}, version = 1)

public abstract class QuizDatabase extends RoomDatabase {

    public abstract QuestionDAO questionDao();

    private static volatile QuizDatabase instance;

    public static synchronized QuizDatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),

                            QuizDatabase.class, "questions_db")

                    .fallbackToDestructiveMigration()

                    .build();
        }

        return instance;
    }
}