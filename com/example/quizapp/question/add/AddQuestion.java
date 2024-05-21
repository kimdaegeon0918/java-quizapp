package com.example.quizapp.question.add;

import com.example.quizapp.util.InputUtil;
import com.example.quizapp.question.MultipleChoiceQuestion;
import com.example.quizapp.question.TrueFalseQuestion;
import com.example.quizapp.question.MultiSelectQuestion;
import com.example.quizapp.question.Question;
import com.example.quizapp.util.IsValid;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AddQuestion {
    private final List<Question> questions;
    private final InputUtil input = new InputUtil();
    private final IsValid isvalid = new IsValid();

    public AddQuestion(List<Question> questions){
        this.questions = questions;
    }

    public List<Question> addQuestion() {
        while(true) {
            System.out.println("1: 객관식 1개 고르기 문제");
            System.out.println("2: 객관식 모두 고르기 문제");
            System.out.println("3: O/X 문제");
            System.out.print("퀴즈 타입을 골라주세요 : ");

            switch(input.get()){
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
                    System.out.println("1,2,3 중에 입력해주세요.");
            }
        }
    }

    private void addMultipleChoiceQuestion() {
        String questionText;
        String numOptions;
        List<String> options;
        String correctAnswer;

        System.out.print("문제를 내주세요 : ");
        questionText = input.get();

        while (true) {
            System.out.print("보기 개수를 입력하세요 : ");
            numOptions = input.get();
            if (isvalid.isValidOption(numOptions)) {
                break;
            }
            System.out.println("보기 개수는 2~5 숫자 중 골라주세요.");
        }

        options = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(numOptions); i++) {
            System.out.print("보기 " + (i + 1) + ": ");
            options.add(input.get());
        }

        while (true) {
            System.out.print("정답을 입력하세요 : ");
            correctAnswer = input.get();
            if (isvalid.isValidAnswer(correctAnswer, Integer.parseInt(numOptions))) {
                break;
            }
            System.out.println("보기 중에서 골라주세요.");
        }
        questions.add(new MultipleChoiceQuestion(questionText, correctAnswer, options));
    }

    private void addMultiSelectQuestion() {
        String questionText;
        String numOptions;
        List<String> options;
        String correctAnswer;

        System.out.print("문제를 내주세요 : ");
        questionText = input.get();

        while (true) {
            System.out.print("보기 개수를 입력하세요 : ");
            numOptions = input.get();
            if (isvalid.isValidOption(numOptions)) {
                break;
            }
            System.out.println("보기 개수는 2~5 숫자 중 골라주세요.");
        }

        options = new ArrayList<>();
        for (int j = 0; j < Integer.parseInt(numOptions); j++) {
            System.out.print("보기 " + (j + 1) + ": ");
            options.add(input.get());
        }

        while (true) {
            System.out.print("정답을 입력하세요. 콤마로 구분. 순서는 상관 없습니다. : ");
            correctAnswer = input.get();
            try {
                List<String> numberList = new ArrayList<>();
                for (String number : correctAnswer.split(",")) {
                    Integer.parseInt(number);
                    if (!isvalid.isValidAnswer(number,Integer.parseInt(numOptions))) {
                        throw new Exception("보기의 숫자를 입력해주세요.");
                    }
                    if (numberList.contains(number)) {
                        throw new Exception("중복된 숫자가 있습니다.");
                    }
                    numberList.add(number);
                }
                Collections.sort(numberList);
                questions.add(new MultiSelectQuestion(questionText, String.join(",", numberList), options));
                return;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addTrueFalseQuestion() {
        String questionText;
        String correctAnswer;

        System.out.print("문제를 내주세요 : ");
        questionText = input.get();

        while (true){
            System.out.print("정답을 입력하세요 (O/X): ");
            correctAnswer = input.get();
            if (isvalid.isValidTFAnswer(correctAnswer)){
                break;
            }
            System.out.println("O/X 만 입력해주세요.");
        }
        questions.add(new TrueFalseQuestion(questionText, correctAnswer));
    }
}