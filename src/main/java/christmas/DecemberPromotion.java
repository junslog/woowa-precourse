package christmas;

import christmas.controller.DayController;
import christmas.controller.OrdersController;
import christmas.controller.PromotionController;
import christmas.domain.DecemberDay;
import christmas.domain.Orders;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class DecemberPromotion {
    private final InputView inputView;
    private final OutputView outputView;
    private final DayController dayController;
    private final OrdersController ordersController;
    private final PromotionController promotionController;

    public DecemberPromotion(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        dayController = new DayController(inputView, outputView);
        ordersController = new OrdersController(inputView, outputView);
        promotionController = new PromotionController(inputView, outputView);
    }

    public void run() {
        outputView.printGreetingMessage();
        DecemberDay day = dayController.insertDay();
        Orders orders = ordersController.insertOrders();
        System.out.println(orders.calculateTotalAmount());
        System.out.println("크리스마스 : " + day.isChristmasPromotionApplicable());
        System.out.println("주말 : " + day.isWeekendPromotionApplicable());
        System.out.println("평일 : " + day.isWeekdayPromotionApplicable());
        System.out.println("특별 : " + day.isSpecialPromotionApplicable());
    }
}