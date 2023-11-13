package christmas.view.input.validator;

import static christmas.view.input.constant.InputConstant.DAY_MAX_INPUT_LENGTH;

public class DayInputValidator extends BasicValidator {
    public void validate(String day) {
        super.validate(day, DAY_MAX_INPUT_LENGTH);
    }
}