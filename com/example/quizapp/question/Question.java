package com.example.quizapp.question;

public abstract class Question {
    private final String questionText;
    private final String correctAnswer;

    public Question(String questionText, String correctAnswer){
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText(){
        return questionText;
    }

    public boolean checkAnswer(String answer){
        return correctAnswer.equalsIgnoreCase(answer);
    }

    public abstract void displayQuestion();

}
