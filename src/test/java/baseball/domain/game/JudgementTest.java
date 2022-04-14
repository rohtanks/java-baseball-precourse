package baseball.domain.game;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgementTest {
    @ParameterizedTest
    @CsvSource(
            value = {"369:3스트라이크", "319:2스트라이크", "123:1볼", "124:낫싱", "629:1볼 1스트라이크"}
            , delimiter = ':')
    @DisplayName(value = "결과 369, 입력에 대한 판정결과 확인")
    void 판정결과_테스트(String input, String expected) {
        String number = "369";
        Judgement judgement = new Judgement();
        System.out.println(input + " / " + expected);
        assertThat(judgement.judge(number, input)).isEqualTo(expected);
    }

}
