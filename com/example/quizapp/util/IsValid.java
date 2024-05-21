package com.example.quizapp.util;


public class IsValidChoice {
    public boolean isValid(String choice){
        try{
            int number = Integer.parseInt(choice);
            if (number > 3 || number < 1) return false;
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
