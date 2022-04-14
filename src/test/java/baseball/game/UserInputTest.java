package baseball.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "349"})
    void 사용자정상입력_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInput userInput = new UserInput();
        List<String> userInputList = userInput.getUserInputList();

        assertThat(userInputList)
                .isNotEmpty()
                .containsAll(Arrays.asList(input.split("")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"122", "4987", "가나다", "54T"})
    void 사용자비정상입력_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInput userInput = new UserInput();
        assertThatThrownBy(() -> {
            userInput.getUserInputList();
        }).isInstanceOf(IllegalArgumentException.class)
                .as("예외발생");
    }
}
