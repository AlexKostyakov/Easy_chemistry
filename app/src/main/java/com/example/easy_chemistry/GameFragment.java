package com.example.easy_chemistry;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class GameFragment extends Fragment {
    private QuestionViewModel questionViewModel;
    private TextView textView;
    private RadioGroup radioGroup;
    private Button button;
    private int indexator = 0;
    public static int COUNT_OF_QUESTIONS = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        textView = view.findViewById(R.id.questionTextView);

        radioGroup = view.findViewById(R.id.answersGroup);

        button = view.findViewById(R.id.nextButton);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        questionViewModel.insert(new Question(
                "Ты уверен что это уже есть в базе данных?",
                List.of("Да", "Нет", "Не очень", "Я не знаю"),
                0
        ));
        questionViewModel.getAllQuestions().observe(getViewLifecycleOwner(), questions -> {
            if (questions != null && !questions.isEmpty()) {
                List<Question> listQuestions = new ArrayList<>(questions);
//                List<Question> randomQuestionsList = selectRandomQuestions(listQuestions);
                RadioButton radioButton = new RadioButton(requireContext());
                radioButton.setText(questions.get(0).getAnswers().get(0));
                radioGroup.addView(radioButton);
            }
        });
        button.setOnClickListener(v -> {
            indexator += 1;
            if (indexator < COUNT_OF_QUESTIONS){
                showQuestion();
            }
            else {
                onFinishGame();
            }

        });
    }

    private void onFinishGame() {
    }

    private void showQuestion(Question question) {
        textView.setText(question.getText());
        radioGroup.removeAllViews();
        RadioButton radioButton = new RadioButton(requireContext());
        for (int i = 0; i < question.getAnswers().size(); i++) {
            radioButton.setText(question.getAnswers().get(i));
            radioGroup.addView(radioButton);
        }
    }
    private List<Question> selectRandomQuestion(List<Question> list){
        List<Question>

    }
}