package christmas.view.input.exception;

import christmas.view.input.exception.message.BasicInputExceptionMessage;

public class BasicInputException extends IllegalArgumentException {
    private BasicInputException(final BasicInputExceptionMessage invalidDayExceptionMessage) {
        super(invalidDayExceptionMessage.getMesage());
    }

    public static BasicInputException of(final BasicInputExceptionMessage basicInputExceptionMessage) {
        return new BasicInputException(basicInputExceptionMessage);
    }
}