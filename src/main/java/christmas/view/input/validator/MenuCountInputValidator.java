package christmas.view.input.validator;

import static christmas.view.input.constant.InputNumberConstant.MENU_COUNT_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputSymbolConstant.ORDER_SYMBOL;

public class MenuCountInputValidator extends BasicValidator {
    public void validate(final String count) {
        super.validate(count, ORDER_SYMBOL.getSymbol(), MENU_COUNT_MAX_INPUT_LENGTH.getValue());
    }
}