package christmas.view.output.constant;

public enum OutputSymbolConstant {
    NEW_LINE(System.lineSeparator()),
    ORDERED_MENUS("<주문 메뉴>");

    private final String symbol;

    OutputSymbolConstant(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}