package com.example.quizapp.question;

import java.util.List;

public abstract class ChoiceQuestion extends Question {
    private final List<String> options;

    public ChoiceQuestion(String questionText, String correctAnswer, List<String> options) {
        super(questionText, correctAnswer);
        this.options = options;
    }

    // 문제 출제
    @Override
    public void displayQuestion() {
        System.out.println(getQuestionText());
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ": " + options.get(i));
        }
    }
}

