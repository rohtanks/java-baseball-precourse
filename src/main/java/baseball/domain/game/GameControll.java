package baseball.domain.game;

import baseball.domain.number.BaseballNumber;
import baseball.domain.user.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class GameControll {
    private final static String SUCCESS_TXT = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private final static String REPLAY_TXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String STRIKE_TXT = "3스트라이크";

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
        String result = "";

        while (!STRIKE_TXT.equals(result)) {
            result = judgement.judge(answer, userInput.getUserInput());
            System.out.println(result);
        }
        System.out.println(SUCCESS_TXT);
        return replay();
    }

    public String replay() {
        System.out.println(REPLAY_TXT);
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