package baseball;

import baseball.domain.game.GameControll;
import baseball.domain.game.Judgement;
import baseball.domain.number.BaseballNumber;
import baseball.domain.user.UserInput;

public class Application {
    public static void main(String[] args) {
        BaseballNumber baseballNumber = new BaseballNumber();
        UserInput userInput = new UserInput();
        Judgement judgement = new Judgement();
        GameControll gameControll = new GameControll(baseballNumber, userInput, judgement);
        while (!"2".equals(gameControll.start())) {
        }
        System.out.println("게임 종료");
    }
}
