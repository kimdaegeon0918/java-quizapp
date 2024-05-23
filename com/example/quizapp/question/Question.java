package com.example.quizapp.question;

public abstract class Question {
    private final String questionText;
    private final String correctAnswer;

    public Question(String questionText, String correctAnswer){
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    // 문제 반환
    public String getQuestionText(){
        return questionText;
    }

    // 정답 체크
    public boolean checkAnswer(String answer){
        return correctAnswer.equalsIgnoreCase(answer);
    }

    // 문제 출제
    public abstract void displayQuestion();

}
