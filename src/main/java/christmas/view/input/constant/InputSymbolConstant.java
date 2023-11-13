package christmas.view.input.constant;

public enum InputSymbolConstant {
    BLANK(" "),
    VOID(""),
    ORDERS_DELIMITER(","),
    ORDER_DELIMITER("-"),
    DAY_SYMBOL("날짜"),
    ORDERS_SYMBOL("주문 내역"),
    ORDER_SYMBOL("주문"),
    MENU_NAME_SYMBOL("메뉴 이름"),
    MENU_COUNT_SYMBOL("메뉴 개수");

    private final String symbol;

    InputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}