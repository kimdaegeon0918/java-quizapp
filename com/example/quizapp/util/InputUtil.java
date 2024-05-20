package com.example.quizapp.util;

import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner = new Scanner(System.in);

    public int getChoice(){
        while (true){
            try{
                String type = scanner.nextLine();
                return Integer.parseInt(type);
            }
            catch (NumberFormatException e){
                System.out.println("숫자를 입력해 주세요.");
            }
        }
    }

    public int getOption(){
        while (true){
            try{
                int option = Integer.parseInt(scanner.nextLine());
                if (option < 2) {
                    throw new Exception("보기는 2개 이상이어야 합니다.");
                }
                else if (option > 5) {
                    throw new Exception("보기는 최대 5개입니다.");
                }
                return option;
            }
            catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}