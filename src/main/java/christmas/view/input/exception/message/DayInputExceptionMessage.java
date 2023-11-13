package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum DayInputExceptionMessage {
    NOT_NUMERIC_TYPE(ERROR_PREFIX + "숫자 형식 입력이 아닙니다. 다시 입력해 주세요.");

    private final String message;

    DayInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}