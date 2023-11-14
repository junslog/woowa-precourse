package christmas.view.input.parser;

import static christmas.view.input.constant.InputNumberConstant.APPLICATION_MAX_INPUT_LENGTH;
import static christmas.view.input.constant.InputNumberConstant.MENU_COUNT_INDEX;
import static christmas.view.input.constant.InputNumberConstant.MENU_NAME_INDEX;
import static christmas.view.input.constant.InputSymbolConstant.BLANK;
import static christmas.view.input.constant.InputSymbolConstant.DAY_SYMBOL;
import static christmas.view.input.constant.InputSymbolConstant.ORDERS_DELIMITER;
import static christmas.view.input.constant.InputSymbolConstant.ORDER_DELIMITER;
import static christmas.view.input.constant.InputSymbolConstant.ORDER_SYMBOL;
import static christmas.view.input.constant.InputSymbolConstant.VOID;
import static christmas.view.input.exception.message.BasicInputExceptionMessage.TOO_LONG_WITH_BLANKS;

import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.DayInputException;
import christmas.view.input.validator.DayInputValidator;
import christmas.view.input.validator.OrderInputValidator;
import christmas.view.input.validator.OrdersInputValidator;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class InputParser {
    private final DayInputValidator dayInputValidator;
    private final OrdersInputValidator ordersInputValidator;
    private final OrderInputValidator orderInputValidator;

    public InputParser() {
        this.dayInputValidator = new DayInputValidator();
        this.ordersInputValidator = new OrdersInputValidator();
        this.orderInputValidator = new OrderInputValidator();
    }

    public int parseDay(String userInput) throws BasicInputException, DayInputException {
        checkDayLengthIsUnderUpperLimit(userInput);
        userInput = removeBlank(userInput);
        dayInputValidator.validate(userInput);
        return parseToInt(userInput);
    }

    public Map<String, Integer> parseOrders(String userInput) {
        checkOrdersLengthIsUnderUpperLimit(userInput);
        userInput = removeBlank(userInput);
        ordersInputValidator.validate(userInput);
        validateEachOrder(userInput);
        return parseToOrderMap(userInput);
    }

    private void checkDayLengthIsUnderUpperLimit(final String userInput) {
        if (userInput.length() > APPLICATION_MAX_INPUT_LENGTH.getValue()) {
            throw BasicInputException.of(String.format(TOO_LONG_WITH_BLANKS.getMessage(), DAY_SYMBOL.getSymbol()));
        }
    }

    private void checkOrdersLengthIsUnderUpperLimit(final String userInput) {
        if (userInput.length() > APPLICATION_MAX_INPUT_LENGTH.getValue()) {
            throw BasicInputException.of(String.format(TOO_LONG_WITH_BLANKS.getMessage(), ORDER_SYMBOL.getSymbol()));
        }
    }

    private int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    private String removeBlank(String userInput) {
        if (userInput.contains(BLANK.getSymbol())) {
            userInput = userInput.replace(BLANK.getSymbol(), VOID.getSymbol());
        }
        return userInput;
    }

    private void validateEachOrder(final String userInput) {
        Arrays.stream(userInput.split(ORDERS_DELIMITER.getSymbol()))
                .forEach(orderInputValidator::validate);
    }

    private Map<String, Integer> parseToOrderMap(final String userInput) {
        return Arrays.stream(userInput.split(ORDERS_DELIMITER.getSymbol()))
                .map(orders -> orders.split(ORDER_DELIMITER.getSymbol()))
                .collect(Collectors.toMap(
                        order -> order[MENU_NAME_INDEX.getValue()],
                        order -> parseToInt(order[MENU_COUNT_INDEX.getValue()])
                ));
    }
}