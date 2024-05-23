package com.example.quizapp.quiz.run;

import com.example.quizapp.question.Question;
import com.example.quizapp.util.InputUtil;

import java.util.List;

public class Quiz {
    InputUtil input = new InputUtil();
    public Quiz(){}

    public void start(List<Question> questions){
        int score = 0;

        // 문제 순차적으로 출제
        for (Question question : questions) {
            System.out.println("-".repeat(130));
            question.displayQuestion();
            System.out.print("답을 입력해주세요 : ");
            String answer = input.get();
            if (question.checkAnswer(answer)) {
                score++;
                System.out.println("정답입니다!");
            } else {
                System.out.println("오답입니다.");
            }
        }
        System.out.println("결과 : " + questions.size() + "점 만점에 " + score + "점");
    }
}
