### 프로그램 개요

- 퀴즈 시작하기 / 문제 추가하기 기능이 있는 프로그램입니다.
- 객관식 단일 선택 문제 , 객관식 다중 선택 문제, OX문제 3가지 문제 종류가 있습니다.
- 퀴즈 시작시 있는 문제와 추가된 문제를 순서대로 출제 후 다 풀면 결과를 알려줍니다.
- 문제당 제한시간과 퀴즈 제한시간이 있습니다.
  - 문제당 제한시간이 지나고 제출하면 오답이 됩니다.
  - 문제를 맞추면 시간 추가, 오답을 제출하거나 시간을 초과하면 시간 차감이 됩니다.
  - 퀴즈 제한시간이 지나면 남은 문제들은 오답이 됩니다.

### 패키지 / 클래스 / 메서드 설명

<img width="381" alt="스크린샷 2024-06-02 오후 5 30 08" src="https://github.com/kimdaegeon0918/java-quizapp/assets/105616992/7f687f01-188a-4b23-adfa-09c9d08b05c6">

### main 패키지

- Main 클래스 : 전체 프로그램을 진행하는 클래스
    - main : 문제 초기화, 메뉴 선택
        - 메뉴 1 선택 → Addquestion.addQuestion 호출
        - 메뉴 2 선택 → Quiz.start 호출
    - printMenu : 메뉴 보여주기

### quiz.run 패키지

- Quiz 클래스 : 퀴즈 게임 진행 클래스
    - start : 문제 출제, 결과 보여주기
        - Question.displayQuestion 호출
        - Question.checkAnswer 호출

### util 패키지

- InputUtil : 사용자 입력 처리 클래스
    - get : 문자열 입력받아서 반환
    - closeScanner : scanner 닫기
- IsValid : 입력받은 데이터 유효성 검사 클래스
    - isValidOption : 보기 개수 유효성 검사
    - isValidAnswer : 객관식 문제 정답 유효성 검사
    - isValidTFAnswer : OX 문제 정답 유효성 검사

### question 패키지

- Question : 문제를 나타내는 최상위 클래스
    - 생성자(문제,정답)
    - getQuestionText : 문제 텍스트 반환
    - checkAnswer : 정답 확인
    - displayQuestion : 문제 출제
- ChoiceQuestion → Question : 보기가 있는 객관식 문제 클래스
    - 생성자(문제,정답,보기)
    - @Override displayQuestion : 문제 출제 - 보기를 추가로 보여줘야해서 재정의
        - getQuestionText 호출
- MultipleChoiceQuestion → ChoiceQuestion : 정답이 1개인 객관식 문제 클래스
    - 생성자(문제,정답,보기)
    - @Override displayQuestion : 문제 출제 - 문제에 대한 텍스트가 달라서 재정의
        - getQuestionText 호출
- MultiSelectQuestion → ChoiceQuestion : 정답이 1개 이상인 객관식 문제 클래스
    - 생성자(문제,정답,보기)
    - @Override displayQuestion : 문제 출제 - 문제에 대한 텍스트가 달라서 재정의
        - getQuestionText 호출
- TrueFalseQuestion → Question : O/X 문제 클래스
    - 생성자(문제,정답)
    - @Override displayQuestion : 문제 출제 - 문제에 대한 텍스트가 달라서 재정의
        - getQuestionText 호출

### question.add 패키지

- AddQuestion : 문제를 추가하는 클래스
    - 생성자(문제 리스트)
    - addQuestion : 문제 종류 선택 후 문제 추가
        - 1 선택 → addMultipleChoiceQuestion : 객관식 단일 선택 문제 추가
        - 2 선택 → addMultiSelectQuestion : 객관식 다중 선택 문제 추가
        - 3 선택 → addTrueFalseQuestion : OX 문제 추가

### timer 패키지
  - QuestionTimer 클래스
    - 문제당 제한시간은 상수로 주어집니다.
    - 1초마다 시간이 줄어듭니다.
    - 문제 남은시간이 0초 이하가 되면 → 해당 문제 오답처리 및 퀴즈 남은시간에 시간 차감
    - 메서드
        - isTimeOut : 타임아웃 여부 반환
- QuizTimer 클래스
    - 퀴즈 제한시간은 문제당 제한시간과 문제 수의 곱으로 정해집니다.
    - 1초마다 시간이 줄어듭니다.
    - 퀴즈 남은시간이 0초 이하가 되면 → 해당 문제 오답처리 및 남은 문제 오답처리
    - 메서드
        - getRemainingTotalTime : 남은시간 반환
        - isTotalTimeOut : 타임아웃 여부 반환
        - changeRemainingTotalTime : 남은 시간 변경




