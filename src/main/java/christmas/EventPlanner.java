package christmas;

import christmas.controller.DayController;
import christmas.controller.OrdersController;
import christmas.domain.DecemberDay;
import christmas.domain.Orders;
import christmas.service.EventService;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class EventPlanner {
    private final OutputView outputView;
    private final DayController dayController;
    private final OrdersController ordersController;
    private final EventService eventService;

    public EventPlanner(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        dayController = new DayController(inputView, outputView);
        ordersController = new OrdersController(inputView, outputView);
        eventService = new EventService();
        outputView.printGreetingMessage();
    }

    public void execute() {
        DecemberDay day = dayController.insertDay();
        Orders orders = ordersController.insertOrders();
        printResult(day, orders);
    }

    private void printResult(final DecemberDay day, final Orders orders) {
        printIntroMessage(day);
        printOrderedMenus(orders);
    }

    private void printIntroMessage(final DecemberDay day) {
        outputView.announceIntroMessage(getDay(day));
    }

    private int getDay(DecemberDay day) {
        return day.getDay();
    }

    public void printOrderedMenus(final Orders orders) {
        outputView.printOrderedMenus(ordersController.createOrderedMenusDto(orders));
    }
}