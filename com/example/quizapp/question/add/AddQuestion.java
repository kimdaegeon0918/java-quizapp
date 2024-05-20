package com.example.quizapp.question.add;

import com.example.quizapp.util.InputUtil;
import com.example.quizapp.question.MultipleChoiceQuestion;
import com.example.quizapp.question.TrueFalseQuestion;
import com.example.quizapp.question.MultiSelectQuestion;
import com.example.quizapp.question.Question;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AddQuestion {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Question> questions;
    private final InputUtil input = new InputUtil();

    public AddQuestion(List<Question> questions){
        this.questions = questions;
    }

    public List<Question> addQuestion(){
        while (true){
            System.out.println("1: 객관식 1개 고르기 문제");
            System.out.println("2: 객관식 모두 고르기 문제");
            System.out.println("3: O/X 문제");
            System.out.print("퀴즈 타입을 골라주세요 : ");
            switch (scanner.nextLine()) {
                case "1":
                    addMultipleChoiceQuestion();
                    return questions;
                case "2":
                    addMultiSelectQuestion();
                    return questions;
                case "3":
                    addTrueFalseQuestion();
                    return questions;
                default:
                    System.out.println("1,2,3 중에 골라주세요.");
            }
        }
    }

    private void addMultipleChoiceQuestion() {
        System.out.print("문제를 내주세요 : ");
        String questionText = scanner.nextLine();

        System.out.print("보기 개수를 입력하세요 : ");
        int numOptions = input.getOption();

        List<String> options = new ArrayList<>();
        for (int i = 0; i < numOptions; i++) {
            System.out.print("보기 " + (i+1) + ": ");
            options.add(scanner.nextLine());
        }

        while (true){
            System.out.print("정답을 입력하세요 : ");
            try{
                int correctAnswer = Integer.parseInt(scanner.nextLine());
                if (correctAnswer < 1 || correctAnswer > numOptions) throw new Exception("보기의 숫자를 입력해주세요.");
                questions.add(new MultipleChoiceQuestion(questionText,String.valueOf(correctAnswer),options));
                return;
            }
            catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void addMultiSelectQuestion() {
        System.out.print("문제를 내주세요 : ");
        String questionText = scanner.nextLine();

        System.out.print("보기 개수를 입력하세요 : ");
        int numOptions = input.getOption();

        List<String> options = new ArrayList<>();
        for (int i = 0; i < numOptions; i++) {
            System.out.print("보기 " + (i+1) + ": ");
            options.add(scanner.nextLine());
        }

        while (true) {
            try {
                System.out.print("정답을 입력하세요. 콤마로 구분. 순서는 상관 없습니다. : ");
                String correctAnswers = scanner.nextLine();
                List<String> numberList = new ArrayList<>();
                for (String number : correctAnswers.split(",")) {
                    int num = Integer.parseInt(number);
                    if (num < 1 || num > numOptions) {
                        throw new Exception("보기의 숫자를 입력해주세요.");
                    }
                    if (numberList.contains(number)){
                        throw new Exception("중복된 숫자가 있습니다.");
                    }
                    numberList.add(number);
                }
                Collections.sort(numberList);
                questions.add(new MultiSelectQuestion(questionText, String.join(",", numberList), options));
                return;
            }
            catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void addTrueFalseQuestion() {
        System.out.print("문제를 내주세요 : ");
        String questionText = scanner.nextLine();

        while (true){
            System.out.print("정답을 입력하세요 (O/X): ");
            String correctAnswer = scanner.nextLine();
            if (correctAnswer.equalsIgnoreCase("O") || correctAnswer.equalsIgnoreCase("X")){
                questions.add(new TrueFalseQuestion(questionText, correctAnswer));
                return;
            }
            System.out.println("O/X 만 입력해주세요.");
        }
    }
}
