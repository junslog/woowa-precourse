package christmas.view.output;

import static christmas.view.output.constant.OutputFormatConstant.GIFT_PRINT_FORMAT;
import static christmas.view.output.constant.OutputFormatConstant.ORDERED_MENUS_PRINT_FORMAT;
import static christmas.view.output.constant.OutputFormatConstant.PRICE_FORMAT_STYLE;
import static christmas.view.output.constant.OutputFormatConstant.SHOW_RESULT_INTRO_FORMAT;
import static christmas.view.output.constant.OutputFormatConstant.TOTAL_AMOUNT_WITH_NO_DISCOUNT_PRINT_FORMAT;
import static christmas.view.output.constant.OutputMessageConstant.GREETING;
import static christmas.view.output.constant.OutputMessageConstant.INSERT_ORDERS;
import static christmas.view.output.constant.OutputMessageConstant.INSERT_RESERVATION_DAY;
import static christmas.view.output.constant.OutputSymbolConstant.GIFT_MENU;
import static christmas.view.output.constant.OutputSymbolConstant.NEW_LINE;
import static christmas.view.output.constant.OutputSymbolConstant.NO_GIFT;
import static christmas.view.output.constant.OutputSymbolConstant.ORDERED_MENUS;
import static christmas.view.output.constant.OutputSymbolConstant.TOTAL_AMOUNT_WITH_NO_DISCOUNT;

import christmas.dto.EventBenefitsPreviewDto;
import christmas.dto.GiftDto;
import christmas.dto.OrderedMenusDto;
import christmas.dto.TotalAmountWithNoDiscountDto;
import java.text.DecimalFormat;
import java.util.Optional;

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

    public void printIntroMessage(EventBenefitsPreviewDto eventBenefitsPreviewDto) {
        printFormatted(SHOW_RESULT_INTRO_FORMAT.getFormat(), eventBenefitsPreviewDto.getDay());
        printLine();
        printLine();
    }

    public void printOrderedMenus(OrderedMenusDto orderedMenusDto) {
        print(ORDERED_MENUS.getSymbol());
        printLine();
        orderedMenusDto.getOrders().forEach(this::printOrderedMenu);
    }

    private void printOrderedMenu(final String menuName, final int menuCount) {
        printFormatted(ORDERED_MENUS_PRINT_FORMAT.getFormat(), menuName, menuCount);
        printLine();
    }

    public void printTotalAmountWithNoDiscount(TotalAmountWithNoDiscountDto totalAmountWithNoDiscountDto) {
        printLine();
        print(TOTAL_AMOUNT_WITH_NO_DISCOUNT.getSymbol());
        printLine();
        printFormattedWithPrice(TOTAL_AMOUNT_WITH_NO_DISCOUNT_PRINT_FORMAT.getFormat(),
                formatPrice(totalAmountWithNoDiscountDto.getAmount()));
        printLine();
    }

    public void printGiftMenu(Optional<GiftDto> giftDtoOptional) {
        printLine();
        print(GIFT_MENU.getSymbol());
        printLine();
        giftDtoOptional.ifPresent(this::printGift);
        if (giftDtoOptional.isEmpty()) {
            print(NO_GIFT.getSymbol());
        }
    }

    private void printGift(GiftDto giftDto) {
        giftDto.getGift().forEach((giftName, giftCount) -> {
                    printFormatted(GIFT_PRINT_FORMAT.getFormat(), giftName, giftCount);
                    printLine();
                }
        );
    }

    public void printLine() {
        System.out.print(NEW_LINE.getSymbol());
    }

    public void printErrorMessage(final String message) {
        print(message);
        printLine();
    }

    private void print(final String message) {
        System.out.print(message);
    }

    private void printFormatted(final String format, final Object... args) {
        print(String.format(format, args));
    }

    private String formatPrice(final int price) {
        return new DecimalFormat(PRICE_FORMAT_STYLE.getFormat())
                .format(price);
    }

    private void printFormattedWithPrice(final String format, final String formattedPrice, final Object... args) {
        print(String.format(String.format(format, formattedPrice), args));
    }
}