package christmas.view.input.validator;

import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.message.BasicInputExceptionMessage;

public abstract class BasicValidator {

    protected void validate(final String userInput, final String inputType, final int maxLength) {
        validateNotEmpty(userInput, inputType);
        validateLengthUnderMaxLength(userInput, inputType, maxLength);
    }

    protected void validateNotEmpty(final String userInput, final String inputType) {
        if (userInput.isEmpty()) {
            throw BasicInputException.of(
                    String.format(BasicInputExceptionMessage.EMPTY_FORMAT.getMessage(), inputType));
        }
    }

    protected void validateLengthUnderMaxLength(final String userInput, final String inputType, final int maxLength) {
        if (userInput.length() > maxLength) {
            throw BasicInputException.of(
                    String.format(BasicInputExceptionMessage.TOO_LONG_FORMAT.getMessage(), inputType));
        }
    }
}