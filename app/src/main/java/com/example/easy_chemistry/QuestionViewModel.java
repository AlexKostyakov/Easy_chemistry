package com.example.easy_chemistry;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionRepository questionRepository;
    private LiveData<List<Question>> listLiveData;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        questionRepository = new QuestionRepository(application);
        listLiveData = questionRepository.getAllQuestions();
    }
    public LiveData<List<Question>> getAllQuestions() {
        return listLiveData;
    }
    public void insert(Question question) {
        questionRepository.insert(question);
    }
    public void delete(Question question) {
        questionRepository.delete(question);
    }
}
