package christmas.domain;

import christmas.domain.constant.FoodType;
import christmas.domain.constant.Menu;
import christmas.domain.exception.InvalidOrdersException;

public class Order {
    private final Menu menu;
    private final int count;

    private Order(Menu menu, final int count) {
        this.menu = menu;
        this.count = count;
    }

    public static Order of(final String menuName, final int count) throws InvalidOrdersException {
        return new Order(Menu.searchByName(menuName), count);
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getMenuCount() {
        return count;
    }

    public FoodType getFoodType() {
        return menu.getFoodType();
    }
}