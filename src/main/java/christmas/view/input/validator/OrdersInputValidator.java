package christmas.view.input.validator;

import static christmas.view.input.constant.InputNumberConstant.ORDERS_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputSymbolConstant.ORDER_SYMBOL;

import christmas.view.input.exception.BasicInputException;

public class OrdersInputValidator extends BasicValidator {
    public void validate(final String ordersInput) throws BasicInputException {
        super.validate(ordersInput, ORDER_SYMBOL.getSymbol(), ORDERS_MAX_INPUT_LENGTH.getValue());
    }
}