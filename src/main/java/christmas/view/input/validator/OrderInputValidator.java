package christmas.view.input.validator;

import static christmas.view.input.constant.InputConstant.ORDER_MAX_INPUT_LENGTH;

public class OrderInputValidator extends BasicValidator {
    public void validate(final String order) {
        super.validate(order, ORDER_MAX_INPUT_LENGTH);
    }
}