package christmas.view.input.validator;

import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.message.BasicInputExceptionMessage;

public abstract class BasicValidator {
    protected void validateNotEmpty(final String userInput) {
        if (userInput.isEmpty()) {
            throw BasicInputException.of(BasicInputExceptionMessage.EMPTY);
        }
    }
}