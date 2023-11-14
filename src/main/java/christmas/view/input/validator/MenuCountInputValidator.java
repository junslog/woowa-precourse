package christmas.view.input.validator;

import static christmas.view.input.constant.InputNumberConstant.MENU_COUNT_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputSymbolConstant.ORDER_SYMBOL;
import static christmas.view.input.exception.message.OrdersInputExceptionMessage.NOT_NUMERIC_TYPE;

import christmas.view.input.exception.OrdersInputException;

public class MenuCountInputValidator extends BasicValidator implements PositiveIntegerCheckable {
    public void validate(final String count) {
        super.validate(count, ORDER_SYMBOL.getSymbol(), MENU_COUNT_MAX_INPUT_LENGTH.getValue());
        validateNumeric(count);
    }

    @Override
    public void validateNumeric(String userInput) {
        try {
            parseToInt(userInput);
        } catch (NumberFormatException e) {
            throw OrdersInputException.of(NOT_NUMERIC_TYPE.getMessage());
        }
    }

    @Override
    public void validatePositive(String userInput) {

    }

    private int parseToInt(final String userInput) {
        return Integer.parseInt(userInput);
    }
}