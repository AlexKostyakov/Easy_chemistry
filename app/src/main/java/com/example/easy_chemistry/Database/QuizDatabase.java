package com.example.easy_chemistry.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.easy_chemistry.DAO.QuestionDAO;
import com.example.easy_chemistry.Question;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Question.class}, version = 1)

public abstract class QuizDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =

            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

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