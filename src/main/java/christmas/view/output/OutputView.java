package christmas.view.output;

import static christmas.view.output.constant.OutputFormatConstant.ORDERED_MENUS_PRINT_FORMAT;
import static christmas.view.output.constant.OutputFormatConstant.SHOW_RESULT_INTRO_FORMAT;
import static christmas.view.output.constant.OutputMessageConstant.GREETING;
import static christmas.view.output.constant.OutputMessageConstant.INSERT_ORDERS;
import static christmas.view.output.constant.OutputMessageConstant.INSERT_RESERVATION_DAY;
import static christmas.view.output.constant.OutputSymbolConstant.NEW_LINE;
import static christmas.view.output.constant.OutputSymbolConstant.ORDERED_MENUS;

import christmas.dto.OrderedMenusDto;

public class OutputView {
    public void printGreetingMessage() {
        print(GREETING.getMessage());
        printLine();
    }

    public void askToInsertReservationDay() {
        print(INSERT_RESERVATION_DAY.getMessage());
        printLine();
    }

    public void askToInsertOrders() {
        print(INSERT_ORDERS.getMessage());
        printLine();
    }

    public void announceIntroMessage(final int day) {
        print(String.format(SHOW_RESULT_INTRO_FORMAT.getFormat(), day));
        printLine();
        printLine();
    }

    public void printOrderedMenus(OrderedMenusDto orderedMenusDto) {
        print(ORDERED_MENUS.getSymbol());
        printLine();
        orderedMenusDto.getOrders().forEach(this::printOrderedMenu);
    }

    private void printOrderedMenu(final String menuName, final int menuCount) {
        print(String.format(ORDERED_MENUS_PRINT_FORMAT.getFormat(), menuName, menuCount));
        printLine();
    }

    public void printLine() {
        System.out.print(NEW_LINE.getSymbol());
    }

    public void printErrorMessage(final String message) {
        print(message);
        printLine();
    }

    private <T> void print(final T message) {
        System.out.print(message);
    }
}