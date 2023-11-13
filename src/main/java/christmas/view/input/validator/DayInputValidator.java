package christmas.view.input.validator;

import static christmas.view.input.constant.InputNumberConstant.DAY_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputNumberConstant.POSITIVE_BOUNDARY_VALUE;
import static christmas.view.input.constant.InputSymbolConstant.DAY_SYMBOL;
import static christmas.view.input.exception.message.DayInputExceptionMessage.NOT_NUMERIC_TYPE;
import static christmas.view.input.exception.message.DayInputExceptionMessage.NOT_POSITIVE;

import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.DayInputException;

public class DayInputValidator extends BasicValidator implements PositiveIntegerCheckable {
    public void validate(final String day) throws BasicInputException, DayInputException {
        super.validate(day, DAY_SYMBOL.getSymbol(), DAY_MAX_INPUT_LENGTH.getValue());
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
        if (day < POSITIVE_BOUNDARY_VALUE.getValue()) {
            throw DayInputException.of(NOT_POSITIVE.getMessage());
        }
    }

    private int parseToInt(final String userInput) {
        return Integer.parseInt(userInput);
    }
}