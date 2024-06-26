package com.example.quizapp.timer;

public class QuestionTimer implements Runnable {
    private final int QUESTION_TIME_LIMIT;
    private final int PENALTY_TIME;
    private boolean timeOut = false;
    private final QuizTimer quizTimer;

    public QuestionTimer(int QUESTION_TIME_LIMIT, QuizTimer quizTimer, int PENALTY_TIME) {
        this.QUESTION_TIME_LIMIT = QUESTION_TIME_LIMIT;
        this.quizTimer = quizTimer;
        this.PENALTY_TIME = PENALTY_TIME;
    }

    // 타이머 작동
    @Override
    public void run() {
        int questionRemainingTime = QUESTION_TIME_LIMIT;
        while (questionRemainingTime > 0 && !Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            // 시간초과시 퀴즈 제한시간에 페널티 부과
            questionRemainingTime--;
            if (questionRemainingTime <= 0) {
                timeOut = true;
                quizTimer.changeRemainingTotalTime(-PENALTY_TIME);
            }
        }
    }

    // 시간초과 여부 반환
    public boolean isTimeOut() {
        return timeOut;
    }
}
