package com.example.quizapp.util;

public class IsValid {
    public boolean isValidOption(String option){
        try{
            int number = Integer.parseInt(option);
            return number <= 5 && number >= 2;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isValidAnswer(String answer,int numOptions){
        try{
            int number = Integer.parseInt(answer);
            return number <= numOptions && number >= 1;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isValidTFAnswer(String answer){
        return (answer.equalsIgnoreCase("O") || answer.equalsIgnoreCase("X"));
    }
}
