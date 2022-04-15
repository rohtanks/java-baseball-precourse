package baseball.domain.game;

import baseball.domain.number.BaseballNumber;
import baseball.domain.user.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class GameControll {

    private final BaseballNumber baseballNumber;
    private final UserInput userInput;
    private final Judgement judgement;

    public GameControll(BaseballNumber baseballNumber, UserInput userInput, Judgement judgement) {
        this.baseballNumber = baseballNumber;
        this.userInput = userInput;
        this.judgement = judgement;
    }

    public String start() {
        baseballNumber.generate();
        String answer = baseballNumber.getNumbers();
//        System.out.println("answer = " + answer);
        String result = "";

        while (!"3스트라이크".equals(result)) {
            String input = userInput.getUserInput();
            result = judgement.judge(answer, input);
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        return replay();
    }

    public String replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateUserInput(input);
        return input;
    }

    private void validateUserInput(String input) {
        if (input.isEmpty())
            throw new IllegalArgumentException("입력값이 없습니다.");
        if (!"1".equals(input) && !"2".equals(input))
            throw new IllegalArgumentException("입력값이 잘못됐습니다.");
    }
}