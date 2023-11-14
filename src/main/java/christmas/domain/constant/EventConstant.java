package christmas.domain.constant;

public enum EventConstant {
    EVENT_APPLICABLE_AMOUNT(10000);

    private final int value;

    EventConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}