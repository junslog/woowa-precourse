package christmas.view.input.exception;

import christmas.domain.exception.message.InvalidDayExceptionMessage;
import christmas.view.input.exception.message.BasicInputExceptionMessage;

public class BasicInputException extends IllegalArgumentException {
    private BasicInputException(final InvalidDayExceptionMessage invalidDayExceptionMessage) {
        super(invalidDayExceptionMessage.getMesage());
    }

    public static BasicInputException of(final BasicInputExceptionMessage basicInputExceptionMessage) {
        return BasicInputException.of(basicInputExceptionMessage);
    }
}