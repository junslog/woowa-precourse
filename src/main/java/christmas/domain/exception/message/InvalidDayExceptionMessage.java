package christmas.domain.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum InvalidDayExceptionMessage {
    NOT_IN_APPROPRIATE_RANGE(ERROR_PREFIX + "유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String mesage;

    InvalidDayExceptionMessage(final String mesage) {
        this.mesage = mesage;
    }

    public String getMesage() {
        return mesage;
    }
}
