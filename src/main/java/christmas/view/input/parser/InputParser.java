package christmas.view.input.parser;

import static christmas.view.input.constant.InputConstant.BLANK;
import static christmas.view.input.constant.InputConstant.VOID;

import christmas.view.input.validator.DayInputValidator;

public class InputParser {
    private final DayInputValidator dayInputValidator;

    public InputParser() {
        this.dayInputValidator = new DayInputValidator();
    }

    public int parseDay(String userInput) {
        userInput = removeBlank(userInput);
        dayInputValidator.validate(userInput);
        return parseToInt(userInput);
    }

    private int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    private String removeBlank(String userInput) {
        if (userInput.contains(BLANK)) {
            userInput = userInput.replace(BLANK, VOID);
        }
        return userInput;
    }
}