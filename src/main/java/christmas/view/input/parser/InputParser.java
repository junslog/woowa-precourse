package christmas.view.input.parser;

import christmas.view.input.validator.DayInputValidator;

public class InputParser {
    private final DayInputValidator dayInputValidator;

    public InputParser() {
        this.dayInputValidator = new DayInputValidator();
    }

    public int parseDay(String userInput) {
        dayInputValidator.validate(userInput);
        return parseToInt(userInput);
    }

    private int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}