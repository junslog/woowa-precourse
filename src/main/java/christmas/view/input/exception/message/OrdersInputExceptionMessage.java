package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;
import static christmas.view.input.constant.InputSymbolConstant.ORDER_DELIMITER;

public enum OrdersInputExceptionMessage {
    INVALID_ORDER_FORMAT(
            ERROR_PREFIX + "유효하지 않은 주문 형식입니다. 다시 입력해 주세요.(주문에 '" + ORDER_DELIMITER.getSymbol() + "'를 포함해주셔야 합니다.)");

    private final String message;

    OrdersInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}