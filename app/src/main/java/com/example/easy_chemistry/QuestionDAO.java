package com.example.easy_chemistry;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDAO {
    @Insert
    void insertQuestion(Question question);
    @Delete
    void deleteQuestion(Question question);
    @Query("SELECT * FROM QUESTIONS_DB")
    LiveData<List<Question>> getAllQuestions();
}
