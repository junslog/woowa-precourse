package christmas.controller;

import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.askUserToInsertReservationDay();
        int day = inputView.getDay();
        System.out.println(day);
    }
}
