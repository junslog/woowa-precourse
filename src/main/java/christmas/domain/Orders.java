package christmas.domain;

import static christmas.domain.constant.OrdersConstant.MAX_MENU_COUNTS;
import static christmas.domain.exception.message.InvalidOrdersExceptionMessage.EXCEED_MENU_COUNTS_UPPER_LIMIT;

import christmas.domain.exception.InvalidOrdersException;
import java.util.List;

public class Orders {
    private final List<Order> orders;

    private Orders(List<Order> orders) {
        this.orders = orders;
    }

    public static Orders from(List<Order> orders) {
        validate(orders);
        return new Orders(orders);
    }

    private static void validate(List<Order> orders) {
        validateSumOfMenuCountsNotExceedUpperLimit(orders);
    }

    private static void validateSumOfMenuCountsNotExceedUpperLimit(List<Order> orders) {
        if (sumOfMenuCountsExceedUpperLimit(orders)) {
            throw InvalidOrdersException.of(EXCEED_MENU_COUNTS_UPPER_LIMIT.getMessage());
        }
    }

    private static boolean sumOfMenuCountsExceedUpperLimit(List<Order> orders) {
        return orders.stream()
                .mapToInt(Order::getMenuCount)
                .sum() > MAX_MENU_COUNTS.getValue();
    }
}