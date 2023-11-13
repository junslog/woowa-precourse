package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum OrdersInputExceptionMessage {
    INVALID_FORMAT(ERROR_PREFIX + "유효하지 않은 주문 형식입니다. 다시 입력해 주세요.");

    private final String message;

    OrdersInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}