package christmas;

import christmas.controller.OrdersController;
import christmas.controller.ReservationDayController;
import christmas.domain.Orders;
import christmas.domain.ReservationDay;
import christmas.service.EventService;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class EventPlanner {
    private final OutputView outputView;
    private final ReservationDayController reservationDayController;
    private final OrdersController ordersController;
    private final EventService eventService;

    public EventPlanner(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        reservationDayController = new ReservationDayController(inputView, outputView);
        ordersController = new OrdersController(inputView, outputView);
        eventService = new EventService();
        outputView.printGreetingMessage();
    }

    public void execute() {
        ReservationDay reservationDay = reservationDayController.insertReservationDay();
        Orders orders = ordersController.insertOrders();
        printResult(reservationDay, orders);
    }

    private void printResult(ReservationDay reservationDay, Orders orders) {
        printIntroMessage(reservationDay);
        printOrderedMenus(orders);
        printTotalAmountWithNoDiscount(orders);
        printGiftMenu(orders);
        printBenefitsDetails(reservationDay, orders);
    }

    private void printIntroMessage(ReservationDay reservationDay) {
        outputView.printIntroMessage(reservationDayController.createEventBenefitsPreviousDto(reservationDay));
    }

    private void printOrderedMenus(Orders orders) {
        outputView.printOrderedMenus(ordersController.createOrderedMenusDto(orders));
    }

    private void printTotalAmountWithNoDiscount(Orders orders) {
        outputView.printTotalAmountWithNoDiscount(ordersController.createTotalAmountWithNoDiscountDto(orders));
    }

    private void printGiftMenu(Orders orders) {
        outputView.printGiftMenu(eventService.createGiftDto(orders));
    }

    private void printBenefitsDetails(ReservationDay reservationDay, Orders orders) {
        outputView.printBenefitsDetails(eventService.createBenefitsDetailsDto(reservationDay, orders));
    }
}