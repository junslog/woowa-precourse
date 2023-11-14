package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum OrdersInputExceptionMessage {
    INVALID_ORDER_FORMAT(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EMPTY_MENU_COUNT(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NOT_NUMERIC_TYPE(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NOT_POSITIVE(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    OrdersInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}