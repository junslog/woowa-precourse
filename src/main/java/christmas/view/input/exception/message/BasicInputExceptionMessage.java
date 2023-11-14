package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum BasicInputExceptionMessage {
    TOO_LONG_WITH_BLANKS(
            ERROR_PREFIX + "유효하지 않은 %s입니다. 다시 입력해 주세요."),
    EMPTY_FORMAT(ERROR_PREFIX + "유효하지 않은 %s입니다. 다시 입력해 주세요."),
    TOO_LONG_FORMAT(ERROR_PREFIX + "유효하지 않은 %s입니다. 다시 입력해 주세요.");

    private final String message;

    BasicInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}