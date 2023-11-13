package christmas.domain.exception;

public class InvalidDayException extends IllegalArgumentException {
    private InvalidDayException(final String invalidDayExceptionMessage) {
        super(invalidDayExceptionMessage);
    }

    public static InvalidDayException of(final String userMoneyInputExceptionMessage) {
        return new InvalidDayException(userMoneyInputExceptionMessage);
    }
}