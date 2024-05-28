package com.example.quizapp.quiz.run;

import com.example.quizapp.question.Question;
import com.example.quizapp.timer.QuestionTimer;
import com.example.quizapp.timer.QuizTimer;
import com.example.quizapp.util.InputUtil;

import java.util.List;

public class Quiz {
    private final InputUtil input = new InputUtil();
    private final int QUESTION_TIME_LIMIT = 10; // 문제당 제한시간
    private final int BONUS_TIME = 3; // 정답시 보너스 시간
    private final int PENALTY_TIME = 15; // 오답시 페널티 시간

    public Quiz(){}

    public void start(List<Question> questions){
        int remainingTotalTime = QUESTION_TIME_LIMIT * questions.size();
        int score = 0;

        // 전체 타이머 스레드 생성
        QuizTimer quizTimer = new QuizTimer(remainingTotalTime);
        Thread quizTimeThread = new Thread(quizTimer);
        quizTimeThread.start();

        // 문제 순차적으로 출제
        for (Question question : questions) {
            if (quizTimer.isTotalTimeOut()) {
                System.out.println("총 제한 시간이 모두 소진되었습니다. 남은 문제는 오답처리됩니다.");
                break;
            }

            printQuestion(question, quizTimer);

            // 문제 타이머 스레드 생성
            QuestionTimer questionTimer = new QuestionTimer(QUESTION_TIME_LIMIT, quizTimer, PENALTY_TIME);
            Thread questionTimeThread = new Thread(questionTimer);

            String answer = inputAnswer(questionTimeThread);

            score = evaluateAnswer(questionTimer, quizTimer, question, answer, score);
        }

        printResult(quizTimeThread, questions.size(), score);

    }

    // 문제 및 남은시간 출력
    public void printQuestion(Question question, QuizTimer totalTimeTimer){
        System.out.println("-".repeat(130));
        question.displayQuestion();
        System.out.println("총 남은 시간 : " + totalTimeTimer.getRemainingTotalTime() + "초");
        System.out.println("문제 제한 시간 : " + QUESTION_TIME_LIMIT + "초");
        System.out.print("답을 입력해주세요 : ");
    }

    // 입력받기
    public String inputAnswer(Thread questionTimeThread){
        questionTimeThread.start();
        String answer = input.get();
        questionTimeThread.interrupt();
        try {
            questionTimeThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }

    // 정답,오답 처리
    public int evaluateAnswer(QuestionTimer questionTimer, QuizTimer totalTimeTimer, Question question, String answer, int score){
        if (questionTimer.isTimeOut() || totalTimeTimer.isTotalTimeOut()) {
            System.out.println("시간이 초과되어 오답처리됩니다. " + PENALTY_TIME + "초가 차감됩니다.");
        } else if (question.checkAnswer(answer)) {
            score++;
            System.out.println("정답입니다! " + BONUS_TIME + "초가 추가됩니다.");
            totalTimeTimer.changeRemainingTotalTime(BONUS_TIME);
        } else {
            System.out.println("오답입니다. " + PENALTY_TIME + "초가 차감됩니다.");
            totalTimeTimer.changeRemainingTotalTime(-PENALTY_TIME);
        }
        return score;
    }

    // 결과 출력 및 스레드 종료
    public void printResult(Thread totalTimeThread, int size, int score){
        System.out.println("결과 : " + size + "점 만점에 " + score + "점");
        totalTimeThread.interrupt();
        try {
            totalTimeThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
