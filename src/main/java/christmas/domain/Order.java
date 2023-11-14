package christmas.domain;

import christmas.domain.constant.Menu;

public class Order {
    private final Menu menu;
    private final int count;

    private Order(Menu menu, final int count) {
        this.menu = menu;
        this.count = count;
    }

    public static Order of(final String menuName, final int count) {
        validate(menuName, count);
        return new Order(Menu.valueOf(menuName), count);
    }

    private static void validate(final String menuName, final int count) {
        validateExistMenu(menuName);
    }

    private static void validateExistMenu(final String menuName) {
        Menu menu = Menu.searchByName(menuName);
    }
}