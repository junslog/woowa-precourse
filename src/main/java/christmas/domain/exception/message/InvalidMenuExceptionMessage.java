package christmas.domain.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum InvalidMenuExceptionMessage {
    NOT_EXISTING_MENU(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    InvalidMenuExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}