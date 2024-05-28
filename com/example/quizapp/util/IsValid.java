package com.example.quizapp.util;

public class IsValid {

    // 보기 개수 유효성 검사
    public boolean isValidOption(String option){
        final int OPTION_MIN = 2;
        final int OPTION_MAX = 5;
        try{
            int number = Integer.parseInt(option);
            return number <= OPTION_MAX && number >= OPTION_MIN;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    // 객관식 문제 정답 유효성 검사
    public boolean isValidAnswer(String answer,int numOptions){
        final int ANSWER_MIN = 1;
        try{
            int number = Integer.parseInt(answer);
            return number <= numOptions && number >= ANSWER_MIN;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    // OX 문제 정답 유효성 검사
    public boolean isValidTFAnswer(String answer){
        final String CORRECT = "O";
        final String INCORRECT = "X";
        return (answer.equalsIgnoreCase(CORRECT) || answer.equalsIgnoreCase(INCORRECT));
    }
}
