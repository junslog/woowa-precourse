package christmas.view.input.validator;

import static christmas.view.input.constant.InputConstant.DAY_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputConstant.POSITIVE_BOUNDARY_VALUE;
import static christmas.view.input.exception.message.DayInputExceptionMessage.NOT_NUMERIC_TYPE;
import static christmas.view.input.exception.message.DayInputExceptionMessage.NOT_POSITIVE;

import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.DayInputException;

public class DayInputValidator extends BasicValidator implements PositiveIntegerCheckable {
    public void validate(final String day) throws BasicInputException, DayInputException {
        super.validate(day, DAY_MAX_INPUT_LENGTH);
        validateNumeric(day);
        validatePositive(day);
    }

    @Override
    public void validateNumeric(final String userInput) {
        try {
            parseToInt(userInput);
        } catch (NumberFormatException e) {
            throw DayInputException.of(NOT_NUMERIC_TYPE.getMessage());
        }
    }

    @Override
    public void validatePositive(final String userInput) {
        int day = parseToInt(userInput);
        if (day < POSITIVE_BOUNDARY_VALUE) {
            throw DayInputException.of(NOT_POSITIVE.getMessage());
        }
    }

    private int parseToInt(final String userInput) {
        return Integer.parseInt(userInput);
    }
}