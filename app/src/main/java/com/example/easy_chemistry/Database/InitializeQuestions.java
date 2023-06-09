package com.example.easy_chemistry.Database;

import android.icu.text.TimeZoneFormat;
import android.util.Size;

import com.example.easy_chemistry.Question;
import com.example.easy_chemistry.QuestionViewModel;

import java.util.List;

public class InitializeQuestions {
    private final QuestionViewModel questionViewModel;


    public InitializeQuestions(QuestionViewModel questionViewModel) {
        this.questionViewModel = questionViewModel;
    }
    public void initialize(){
        questionViewModel.insert(new Question(
                "Выберите правильные данные водорода",
                List.of("H, 1, 1, hydrogenium, аш", "Ga 2, 4, hydrogelium, аш", "V, 3, 7, vodoridyum, во", "Bo, 20, bodorodium, водород"),
                0));
        questionViewModel.insert(new Question(
                "Выберите правильные данные гелия",
                List.of("H, 1, 1, helum, ге", "Не 2, 4, helium, гелий", "Hu, 3, 7, helyrodium, во", "Bo, 20, bodorodium, гелий"),
                1));
        questionViewModel.insert(new Question(
                "Выберите правильные данные лития",
                List.of("Li, 4,  6, lithium, ли", "Li, 5,  10, litium, литиум", "Li, 3,  7, lithium, литий", "Li, 5,  6, litium, ли"),
                2));

    }
}
