package baseball.domain.user;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {
    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();
        validateUserInput(line);
        return line;
    }

    private void validateUserInput(String line) {
        if (line.isEmpty())
            throw new IllegalArgumentException("입력값이 없습니다.");
        if (!line.matches("^[0-9]+$"))
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");

        Set<String> elements = new HashSet<>(Arrays.asList(line.split("")));
        if (elements.size() != 3)
            throw new IllegalArgumentException("입력값에 중복이 있습니다.");
    }
}