package christmas.domain.constant;

public enum OrdersConstant {
    MAX_MENU_COUNTS(20);
    
    private final int value;

    OrdersConstant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}