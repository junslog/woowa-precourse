package christmas.controller;

import christmas.domain.DecemberDay;
import christmas.domain.Orders;
import christmas.domain.exception.InvalidDayException;
import christmas.domain.exception.InvalidOrdersException;
import christmas.service.DayService;
import christmas.service.OrdersService;
import christmas.view.input.InputView;
import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.DayInputException;
import christmas.view.input.exception.OrdersInputException;
import christmas.view.output.OutputView;
import java.util.Map;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DayService dayService;
    private final OrdersService ordersService;

    public PromotionController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.dayService = new DayService();
        this.ordersService = new OrdersService();
    }

    public void run() {
        outputView.printGreetingMessage();
        DecemberDay day = insertDay();
        Orders orders = insertOrders();
        System.out.println(orders.calculateTotalAmount());
        System.out.println(day.isChristmasPromotionApplicable());
        System.out.println(day.isWeekendPromotionApplicable());
    }

    private DecemberDay insertDay() {
        try {
            int reservationDay = askToInsertReservationDay();
            return dayService.createDay(reservationDay);
        } catch (BasicInputException | DayInputException | InvalidDayException e) {
            outputView.printErrorMessage(e.getMessage());
            return insertDay();
        }
    }

    private int askToInsertReservationDay() throws BasicInputException, DayInputException {
        outputView.askToInsertReservationDay();
        return inputView.getDay();
    }

    private Orders insertOrders() {
        try {
            Map<String, Integer> orders = askToInsertOrders();
            return ordersService.createOrders(orders);
        } catch (BasicInputException | OrdersInputException | InvalidOrdersException e) {
            outputView.printErrorMessage(e.getMessage());
            return insertOrders();
        }
    }

    private Map<String, Integer> askToInsertOrders() {
        outputView.askToInsertOrders();
        return inputView.getOrders();
    }
}