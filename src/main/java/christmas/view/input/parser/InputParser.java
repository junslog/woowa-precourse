package christmas.view.input.parser;

import static christmas.view.input.constant.InputConstant.BLANK;
import static christmas.view.input.constant.InputConstant.ORDERS_DELIMITER;
import static christmas.view.input.constant.InputConstant.ORDER_COUNT_INDEX;
import static christmas.view.input.constant.InputConstant.ORDER_DELIMITER;
import static christmas.view.input.constant.InputConstant.ORDER_NAME_INDEX;
import static christmas.view.input.constant.InputConstant.VOID;

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
        userInput = removeBlank(userInput);
        dayInputValidator.validate(userInput);
        return parseToInt(userInput);
    }

    public Map<String, Integer> parseOrders(String userInput) {
        userInput = removeBlank(userInput);
        ordersInputValidator.validate(userInput);
        validateEachOrder(userInput);
        return parseToOrderMap(userInput);
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

    private void validateEachOrder(final String userInput) {
        Arrays.stream(userInput.split(ORDERS_DELIMITER))
                .forEach(orderInputValidator::validate);
    }

    private Map<String, Integer> parseToOrderMap(String userInput) {
        return Arrays.stream(userInput.split(ORDERS_DELIMITER))
                .map(orders -> orders.split(ORDER_DELIMITER))
                .collect(Collectors.toMap(
                        order -> order[ORDER_NAME_INDEX],
                        order -> parseToInt(order[ORDER_COUNT_INDEX])
                ));
    }
}