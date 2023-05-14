package com.example.easy_chemistry.Fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.easy_chemistry.Database.InitializeQuestions;
import com.example.easy_chemistry.Question;
import com.example.easy_chemistry.QuestionViewModel;
import com.example.easy_chemistry.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GameFragment extends Fragment {

    private TextView textView;
    private RadioGroup radioGroup;
    private Button button;
    private static int indexator = 0;
    public static int COUNT_OF_QUESTIONS = 2;
    private List<Question> randomQuestionsList;
    private static final String LOG_TAG = GameFragment.class.getName();
    private static int score = 0;
    private QuestionViewModel questionViewModel;
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
        InitializeQuestions initializeQuestions = new InitializeQuestions(questionViewModel);
        initializeQuestions.initialize();
        questionViewModel.getAllQuestions().observe(getViewLifecycleOwner(), questions -> {
            if (questions != null && !questions.isEmpty()) {
                List<Question> listQuestions = new ArrayList<>(questions);
                randomQuestionsList = selectRandomQuestion(listQuestions);
                Log.d(LOG_TAG,randomQuestionsList.toString());
                showQuestion(randomQuestionsList.get(indexator));

            }
        });
        button.setOnClickListener(v -> {

            RadioButton selectedAnswer = getView().findViewById(radioGroup.getCheckedRadioButtonId());
            if(selectedAnswer != null && selectedAnswer.getText().toString().equals(randomQuestionsList.get(indexator).getCorrectAnswer())){
                score+=10;

            }
            indexator += 1;
            if (indexator < COUNT_OF_QUESTIONS){
                showQuestion(randomQuestionsList.get(indexator));
            }
            else {
                onFinishGame();
            }



        });
    }
    public  void checkAnswer(){

    }

    private void onFinishGame() {
        Dialog dialog = new Dialog(getContext(), R.style.Dialog_Theme);
        dialog.setContentView(R.layout.game_over_dialog);
        TextView textView = dialog.findViewById(R.id.counter_text);
        textView.setText("Ваш счет: " + score);
        Button restartButton = dialog.findViewById(R.id.restart_button);
        Button homeButton = dialog.findViewById(R.id.home_button);
        restartButton.setOnClickListener(v -> {
            Log.d(LOG_TAG, "restart");
            dialog.dismiss();
        });
        homeButton.setOnClickListener(v -> {
            Log.d(LOG_TAG, "home");
            dialog.dismiss();
        });
        dialog.show();
    }

    private void showQuestion(Question question) {
        textView.setText(question.getText());
        radioGroup.removeAllViews();
        for (int i = 0; i < question.getAnswers().size(); i++) {
            RadioButton radioButton = new RadioButton(requireContext());
            radioButton.setText(question.getAnswers().get(i));
            radioGroup.addView(radioButton);
        }
    }
    private List<Question> selectRandomQuestion(List<Question> list){
        List<Question> questionList = new ArrayList<>();
        Collections.shuffle(list);
        for (int i = 0; i < COUNT_OF_QUESTIONS; i++) {
            questionList.add(list.get(i));
        }
        return questionList;

    }
}