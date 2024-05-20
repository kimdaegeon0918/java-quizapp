package com.example.quizapp.quiz.run;

import com.example.quizapp.question.Question;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    public Quiz(){
    }

    public void start(List<Question> questions){
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println("-".repeat(130));
            question.displayQuestion();
            System.out.print("답을 입력해주세요 : ");
            String answer = scanner.nextLine();
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
