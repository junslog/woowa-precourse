package christmas.view.input.validator;

import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.message.BasicInputExceptionMessage;

public abstract class BasicValidator {

    protected void validate(final String userInput, final int maxLength) {
        validateNotEmpty(userInput);
        validateLengthUnderMaxLength(userInput, maxLength);
    }

    protected void validateNotEmpty(final String userInput) {
        if (userInput.isEmpty()) {
            throw BasicInputException.of(BasicInputExceptionMessage.EMPTY.getMesage());
        }
    }

    protected void validateLengthUnderMaxLength(final String userInput, final int maxLength) {
        if (userInput.length() > maxLength) {
            throw BasicInputException.of(String.format(BasicInputExceptionMessage.TOO_LONG.getMesage(), maxLength));
        }
    }
}