package christmas.domain.constant.event;

public enum EventConstant {
    EVENT_APPLICABLE_AMOUNT(10_000),
    GIFT_EVENT_APPLICABLE_AMOUNT(120_000),
    GIFT_CHAMPAGNE_COUNT(1),
    CHRISTMAS_PROMOTION_INCREASING_AMOUNT(100);

    private final int value;

    EventConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}