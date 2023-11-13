package christmas.view.input.validator;

import static christmas.view.input.constant.InputNumberConstant.MENU_COUNT_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputSymbolConstant.MENU_COUNT_SYMBOL;

public class MenuCountInputValidator extends BasicValidator {
    public void validate(final String count) {
        super.validate(count, MENU_COUNT_SYMBOL.getSymbol(), MENU_COUNT_MAX_INPUT_LENGTH.getValue());
    }
}