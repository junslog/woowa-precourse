package christmas.view.input.validator;

import static christmas.view.input.constant.InputConstant.MENU_NAME_MAX_INPUT_LENGTH;

public class MenuNameInputValidator extends BasicValidator {
    public void validate(final String name) {
        super.validate(name, MENU_NAME_MAX_INPUT_LENGTH);
    }
}