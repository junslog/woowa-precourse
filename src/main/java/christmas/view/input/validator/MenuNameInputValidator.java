package christmas.view.input.validator;

import static christmas.view.input.constant.InputNumberConstant.MENU_NAME_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputSymbolConstant.ORDER_SYMBOL;

public class MenuNameInputValidator extends BasicValidator {
    public void validate(final String name) {
        super.validate(name, ORDER_SYMBOL.getSymbol(), MENU_NAME_MAX_INPUT_LENGTH.getValue());
    }
}