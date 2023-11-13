package christmas.view.input.constant;

public enum InputSymbolConstant {
    BLANK(" "),
    VOID(""),
    ORDERS_DELIMITER(","),
    ORDER_DELIMITER("-");

    private final String symbol;

    InputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}