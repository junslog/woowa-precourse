package christmas.view.input.validator;

import static christmas.view.input.constant.InputConstant.DAY_MAX_INPUT_LENGTH;
import static christmas.view.input.exception.message.DayInputExceptionMessage.NOT_NUMERIC_TYPE;

import christmas.view.input.exception.DayInputException;

public class DayInputValidator extends BasicValidator implements NumericTypeCheckable {
    public void validate(final String day) {
        super.validate(day, DAY_MAX_INPUT_LENGTH);
        validateNumeric(day);
    }

    @Override
    public void validateNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw DayInputException.of(NOT_NUMERIC_TYPE.getMessage());
        }
    }
}