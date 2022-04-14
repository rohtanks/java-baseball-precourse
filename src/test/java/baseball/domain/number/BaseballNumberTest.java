package baseball.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberTest {
    @Test
    @DisplayName(value = "생성된 난수의 사이즈 및 범위 체크(100번)")
    void 난수생성_테스트() {
        for (int i = 0; i < 100; i++) {
            BaseballNumber baseballNumber = new BaseballNumber();
            baseballNumber.generate();
            List<String> numberList = Arrays.asList(baseballNumber.getNumbers().split(""));
            assertThat(numberList)
                    .isNotEmpty()
                    .hasSize(NumberEnum.LENGTH.getValue())
                    .allSatisfy(e -> {
                        int number = Integer.parseInt(e);
                        assertThat(number).isGreaterThanOrEqualTo(NumberEnum.START_VALUE.getValue());
                        assertThat(number).isLessThanOrEqualTo(NumberEnum.END_VALUE.getValue());
                    });
        }

    }

}
