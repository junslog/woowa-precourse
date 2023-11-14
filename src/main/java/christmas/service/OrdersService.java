package christmas.service;

import christmas.domain.Order;
import christmas.domain.Orders;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrdersService {
    public Orders createOrders(Map<String, Integer> orders) {
        return Orders.from(makeOrders(orders));
    }

    private List<Order> makeOrders(Map<String, Integer> orders) {
        return orders.entrySet().stream()
                .map(order -> createOrder(order.getKey(), order.getValue()))
                .collect(Collectors.toList());
    }

    private Order createOrder(final String menuName, final int menuCount) {
        return Order.of(menuName, menuCount);
    }
}