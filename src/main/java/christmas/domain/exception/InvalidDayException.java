package christmas.domain.exception;

import christmas.domain.exception.message.InvalidDayExceptionMessage;

public class InvalidDayException extends IllegalArgumentException {
    private InvalidDayException(final InvalidDayExceptionMessage invalidDayExceptionMessage) {
        super(invalidDayExceptionMessage.getMesage());
    }

    public static InvalidDayException of(final InvalidDayExceptionMessage userMoneyInputExceptionMessage) {
        return new InvalidDayException(userMoneyInputExceptionMessage);
    }
}