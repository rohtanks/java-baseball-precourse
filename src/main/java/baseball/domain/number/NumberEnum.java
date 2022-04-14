package baseball.domain.number;

public enum NumberEnum {
    START_VALUE(1),
    END_VALUE(9),
    LENGTH(3);
    
    private int value;

    NumberEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
