package com.example.quizapp.util;

import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner;

    public InputUtil(){
        this.scanner = new Scanner(System.in);
    }

    // 사용자 입력 값 반환
    public String get(){
        return scanner.nextLine(); // 입력이 중단되면 null 반환
    }

    // 자원해제
    public void closeScanner(){
        scanner.close();
    }
}