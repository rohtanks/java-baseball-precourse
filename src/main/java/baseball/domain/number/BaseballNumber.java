package baseball.domain.number;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumber {
    private String numbers = "";

    public String getNumbers() {
        return numbers;
    }

    public void generate() {
        validateLength();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < NumberEnum.LENGTH.getValue()) {
            String number = String.valueOf(
                    Randoms.pickNumberInRange(NumberEnum.START_VALUE.getValue(), NumberEnum.END_VALUE.getValue())
            );
            if (sb.toString().contains(number)) continue;
            sb.append(number);
        }
        this.numbers = sb.toString();
    }

    private void validateLength() {
        if (NumberEnum.LENGTH.getValue() < 0) {
            throw new IllegalArgumentException("count cannot be less than zero.");
        }
        if (NumberEnum.END_VALUE.getValue() - NumberEnum.START_VALUE.getValue() + 1 < NumberEnum.LENGTH.getValue()) {
            throw new IllegalArgumentException("count cannot be greater than the input range.");
        }
    }

    @Override
    public String toString() {
        return "BaseballNumber{" +
                "numbers='" + numbers + '\'' +
                '}';
    }
}
