package christmas.domain.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum InvalidReservationDayExceptionMessage {
    NOT_IN_APPROPRIATE_RANGE(ERROR_PREFIX + "유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    InvalidReservationDayExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}