package christmas.view.input.exception.message;

import static christmas.global.ApplicationConstant.ERROR_PREFIX;
import static christmas.view.input.constant.InputNumberConstant.APPLICATION_MAX_INPUT_LENGTH;

public enum BasicInputExceptionMessage {
    TOO_LONG_WITH_BLANKS(
            ERROR_PREFIX + "제한 글자 입력을 초과했습니다. 다시 입력해 주세요.(공백 포함 최대" + APPLICATION_MAX_INPUT_LENGTH + "글자 입력 가능)"),
    EMPTY(ERROR_PREFIX + "비어있는 입력값입니다. 다시 입력해 주세요."),
    TOO_LONG(ERROR_PREFIX + "제한 글자 입력을 초과했습니다. 다시 입력해 주세요.(공백 제외 최대 %d글자 입력 가능)");

    private final String message;

    BasicInputExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}