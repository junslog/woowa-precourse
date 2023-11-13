package christmas.view.input.validator;

public class DayInputValidator extends BasicValidator {
    public void validate(String day) {
        validateNotEmpty(day);
    }
}