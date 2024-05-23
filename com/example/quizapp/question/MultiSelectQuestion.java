package com.example.quizapp.question;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MultiSelectQuestion extends ChoiceQuestion {
    private final String correctAnswers;

    public MultiSelectQuestion(String questionText, String correctAnswers, List<String> options) {
        super(questionText, correctAnswers, options);
        this.correctAnswers = correctAnswers;
    }

    // 번호 순서대로 정렬해서 정답 확인
    @Override
    public boolean checkAnswer(String answer) {
        List<String> numberList = new ArrayList<>();
        for (String number : answer.split(",")) {
            numberList.add(number);
        }
        Collections.sort(numberList);
        return correctAnswers.equals(String.join(",", numberList));
    }

    // 문제 출제
    @Override
    public void displayQuestion() {
        super.displayQuestion();
        System.out.println("답을 모두 고르세요. 콤마로 구분. 순서는 상관 없습니다.");
    }
}
