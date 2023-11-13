package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;

public enum BasicInputExceptionMessage {
    EMPTY(ERROR_PREFIX + "비어있는 입력값입니다. 다시 입력해 주세요.");

    private final String mesage;

    BasicInputExceptionMessage(final String mesage) {
        this.mesage = mesage;
    }

    public String getMesage() {
        return mesage;
    }
}