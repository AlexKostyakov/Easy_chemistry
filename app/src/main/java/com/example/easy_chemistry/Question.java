package com.example.easy_chemistry;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(tableName = "questions_db")
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String text;
    private List<String> answers;
    private int correct_answer_index;

    public Question(String text, List<String> answers, int correct_answer_index) {
        this.text = text;
        this.answers = answers;
        this.correct_answer_index = correct_answer_index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getCorrect_answer_index() {
        return correct_answer_index;
    }

    public void setCorrect_answer_index(int correct_answer_index) {
        this.correct_answer_index = correct_answer_index;
    }
}
