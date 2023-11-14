package christmas.domain.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum InvalidOrdersExceptionMessage {
    NOT_EXISTING_MENU(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    EXCEED_MENU_COUNTS_UPPER_LIMIT(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENUS_ONLY_CONTAIN_BEVERAGE(ERROR_PREFIX + "유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    InvalidOrdersExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}