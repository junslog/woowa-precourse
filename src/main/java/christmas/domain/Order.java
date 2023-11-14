package christmas.domain;

import christmas.domain.constant.Menu;
import christmas.domain.exception.InvalidMenuException;

public class Order {
    private final Menu menu;
    private final int count;

    private Order(Menu menu, final int count) {
        this.menu = menu;
        this.count = count;
    }

    public static Order of(final String menuName, final int count) throws InvalidMenuException {
        return new Order(Menu.searchByName(menuName), count);
    }
}