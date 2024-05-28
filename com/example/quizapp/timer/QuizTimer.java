package com.example.quizapp.timer;

public class QuizTimer implements Runnable {
    private int remainingTotalTime;
    private boolean totalTimeOut = false;
    private static final int TIME_DECREMENT = -1;

    public QuizTimer(int totalTime) {
        this.remainingTotalTime = totalTime;
    }

    // 타이머 작동
    @Override
    public void run() {
        while (remainingTotalTime > 0 && !Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            changeRemainingTotalTime(TIME_DECREMENT);
        }
    }

    // 현재 남은 시간 반환
    public synchronized int getRemainingTotalTime() {
        return remainingTotalTime;
    }

    // 시간초과 여부 반환
    public synchronized boolean isTotalTimeOut() {
        return totalTimeOut;
    }

    // 총 남은 시간 변경
    public synchronized void changeRemainingTotalTime(int value) {
        remainingTotalTime += value;
        if (remainingTotalTime <= 0){
            totalTimeOut = true;
        }
    }
}
