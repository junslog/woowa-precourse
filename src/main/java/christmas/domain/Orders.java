package christmas.domain;


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
    }
}