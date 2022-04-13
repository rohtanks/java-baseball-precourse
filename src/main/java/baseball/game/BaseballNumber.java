package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {

    private static final int START_VALUE = 1;
    private static final int END_VALUE = 9;

    private int length = 3;
    private Set<Integer> numbers = new HashSet<>();

    public BaseballNumber() {
    }

    public BaseballNumber(int length) {
        this.length = length;
        this.numbers = new HashSet<>(length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public void generate() {
        if (this.length < 0) {
            throw new IllegalArgumentException("count cannot be less than zero.");
        }
        if (END_VALUE - START_VALUE + 1 < length) {
            throw new IllegalArgumentException("count cannot be greater than the input range.");
        }
        while (numbers.size() < length) {
            this.numbers.add(Randoms.pickNumberInRange(START_VALUE, END_VALUE));
        }
    }

    @Override
    public String toString() {
        return "BaseballNumber{" +
                "length=" + length +
                ", numbers=" + numbers +
                '}';
    }
}
