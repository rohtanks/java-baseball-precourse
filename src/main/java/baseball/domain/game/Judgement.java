package baseball.domain.game;

public class Judgement {

    private static final String NOT_TXT = "낫싱";

    public String judge(String number, String input) {
        int ballCount = countBall(number, input);
        int strikeCount = countStrike(number, input);

        if (ballCount == 0 && strikeCount == 0) return NOT_TXT;
        if (strikeCount == 0) return ballCount + "볼";
        if (ballCount == 0) return strikeCount + "스트라이크";
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

    private int countBall(String number, String input) {
        int count = 0;
        if (input.charAt(0) == number.charAt(1) || input.charAt(0) == number.charAt(2)) count++;
        if (input.charAt(1) == number.charAt(0) || input.charAt(1) == number.charAt(2)) count++;
        if (input.charAt(2) == number.charAt(0) || input.charAt(2) == number.charAt(1)) count++;

        return count;
    }

    private int countStrike(String number, String input) {
        int count = 0;
        if (input.charAt(0) == number.charAt(0)) count++;
        if (input.charAt(1) == number.charAt(1)) count++;
        if (input.charAt(2) == number.charAt(2)) count++;

        return count;
    }
}