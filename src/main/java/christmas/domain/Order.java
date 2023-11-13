package christmas.domain;

import christmas.domain.constant.Menu;

public class Order {
    private final Menu menu;
    private final int count;

    private Order(Menu menu, final int count) {
        this.menu = menu;
        this.count = count;
    }

    public static Order of(Menu menu, final int count) {
        validate(menu, count);
        return new Order(menu, count);
    }

    private static void validate(Menu menu, final int count) {

    }
}