package com.example.easy_chemistry;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionRepository {
    private QuestionDAO questionDAO;
    private LiveData<List<Question>> listLiveData;

    public QuestionRepository(Application application) {

        QuizDatabase database = QuizDatabase.getInstance(application);

        questionDAO = database.questionDao();

        listLiveData = questionDAO.getAllQuestions();

    }
    public LiveData<List<Question>> getAllQuestions(){
        return listLiveData;
    }
    public void insert(Question question) {

        QuizDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.insertQuestion(question);
        });
    }

    public void delete(Question question) {
        QuizDatabase.databaseWriteExecutor.execute(() -> {
            questionDAO.deleteQuestion(question);
        });
    }


}
