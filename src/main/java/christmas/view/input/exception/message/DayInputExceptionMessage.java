package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum DayInputExceptionMessage {
    NOT_NUMERIC_TYPE(ERROR_PREFIX + "날짜 입력은 숫자 형식이어야 합니다. 다시 입력해 주세요."),
    NOT_POSITIVE(ERROR_PREFIX + "날짜 입력은 양수여야 합니다. 다시 입력해 주세요.");

    private final String message;

    DayInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}