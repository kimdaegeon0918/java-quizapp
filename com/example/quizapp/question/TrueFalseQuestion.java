package com.example.quizapp.question;

public class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String questionText, String correctAnswer) {
        super(questionText, correctAnswer);
    }

    // 문제 출제
    @Override
    public void displayQuestion() {
        System.out.println(getQuestionText());
        System.out.println("O/X를 입력해주세요.");
    }
}
