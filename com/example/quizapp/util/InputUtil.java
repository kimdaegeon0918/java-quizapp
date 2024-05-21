package com.example.quizapp.util;

import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner;

    public InputUtil(){
        this.scanner = new Scanner(System.in);
    }

    public String get(){
        return scanner.nextLine();
    }

    public void closeScanner(){
        scanner.close();
    }
}