package christmas.view.input.validator;

import static christmas.view.input.constant.InputNumberConstant.ORDERS_MAX_INPUT_LENGTH;

import christmas.view.input.exception.BasicInputException;

public class OrdersInputValidator extends BasicValidator {
    public void validate(final String orders) throws BasicInputException {
        super.validate(orders, ORDERS_MAX_INPUT_LENGTH.getValue());
    }
}