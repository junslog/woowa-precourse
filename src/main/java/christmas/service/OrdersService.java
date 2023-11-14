package christmas.service;

import christmas.domain.Order;
import christmas.domain.Orders;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrdersService {
    public Orders createOrders(Map<String, Integer> orders) {
        List<Order> menusAndCounts = orders.entrySet().stream()
                .map(order -> createOrder(order.getKey(), order.getValue()))
                .collect(Collectors.toList());
        return Orders.from(menusAndCounts);
    }

    private Order createOrder(final String menuName, final int menuCount) {
        return Order.of(menuName, menuCount);
    }
}