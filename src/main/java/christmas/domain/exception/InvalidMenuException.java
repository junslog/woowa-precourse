package christmas.domain.exception;

public class InvalidMenuException extends IllegalArgumentException {
    private InvalidMenuException(final String invalidMenuExceptionMessage) {
        super(invalidMenuExceptionMessage);
    }

    public static InvalidMenuException of(final String invalidMenuExceptionMessage) {
        return new InvalidMenuException(invalidMenuExceptionMessage);
    }
}