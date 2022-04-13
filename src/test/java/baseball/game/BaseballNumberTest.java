package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberTest {
    @ParameterizedTest
    @DisplayName(value = "생성된 난수의 사이즈 및 범위 체크(100번)")
    @ValueSource(ints = {3, 4, 5})
    void 난수생성_테스트(int len) {
        for (int i = 0; i < 100; i++) {
            BaseballNumber baseballNumber = new BaseballNumber(len);
            baseballNumber.generate();
            assertThat(baseballNumber.getNumbers())
                    .isNotEmpty()
                    .hasSize(len)
                    .allSatisfy(integer -> {
                        assertThat(integer).isGreaterThanOrEqualTo(1);
                        assertThat(integer).isLessThanOrEqualTo(9);
                    });
        }

    }

}
