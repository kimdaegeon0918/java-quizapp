package com.example.quizapp.question;

import java.util.List;

public class MultipleChoiceQuestion extends ChoiceQuestion {
    public MultipleChoiceQuestion(String questionText, String correctAnswers, List<String> options) {
        super(questionText, correctAnswers, options);
    }

    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("1개의 답을 고르세요.");
    }
}