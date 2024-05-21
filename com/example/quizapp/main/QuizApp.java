package com.example.quizapp.main;

import com.example.quizapp.question.MultiSelectQuestion;
import com.example.quizapp.question.MultipleChoiceQuestion;
import com.example.quizapp.question.Question;
import com.example.quizapp.question.TrueFalseQuestion;
import com.example.quizapp.question.add.AddQuestion;
import com.example.quizapp.quiz.run.Quiz;
import com.example.quizapp.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class QuizApp {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new MultipleChoiceQuestion("서버 애플리케이션을 구축하기 위해 사용되는 자바스크립트 런타임 환경은?","2", List.of("PYTHON","node.js","JAVA","REACT")));
        questions.add(new MultiSelectQuestion("REST API에 부합하는 규칙은?","1,2,5",List.of("소문자를 사용한다.","확장자를 사용하지 않는다.","URI의 마지막에 슬래시를 포함한다.","밑줄(_)을 사용한다.","리소스명은 동사가 아닌 명사를 사용한다.")));
        questions.add(new TrueFalseQuestion("요소의 색상 변경은 리플로우를 유발한다.","X"));
        questions.add(new MultipleChoiceQuestion("각 인증 요청마다 고유하게 발급되는 한 번만 사용되는 숫자는?","5", List.of("Realm","WWW-Authenticate","OAuth","Hash","Nonce")));
        questions.add(new TrueFalseQuestion("연산 작업을 진행할때 값이 null 또는 undefined일때 대체할 수 있는 값을 지정해두는 기법을 null guarding이라 한다.","O"));
        questions.add(new MultipleChoiceQuestion("git명령어 중 이전 커밋으로 돌아가는데 돌아가는 기록이 남는 명령어는?","1", List.of("git revert","git reset","git restore","git remote","git merge")));
        questions.add(new MultiSelectQuestion("JAVA의 기본 자료형을 고르세요.","2,3",List.of("String","char","double","SomeClass","array")));

        InputUtil input = new InputUtil();
        Quiz quiz = new Quiz();

        while (true){
            printMenu();

            switch(input.get()){
                case "1":
                    AddQuestion addquestion = new AddQuestion(questions);
                    questions = addquestion.addQuestion();
                    break;
                case "2":
                    quiz.start(questions);
                    break;
                case "3":
                    System.out.println("이용해주셔서 감사합니다!");
                    input.closeScanner();
                    return;
                default:
                    System.out.println("1,2,3 중에 입력해주세요.");
                }
            }
        }

    private static void printMenu() {
        System.out.println("=== 메 뉴 ===");
        System.out.println("1. 퀴즈 추가하기");
        System.out.println("2. 퀴즈 시작하기");
        System.out.println("3. 종료하기");
        System.out.print("선택해주세요 : ");
    }
}
