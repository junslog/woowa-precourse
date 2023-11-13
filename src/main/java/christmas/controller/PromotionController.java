package christmas.controller;

import christmas.view.output.OutputView;

public class PromotionController {
    public void run() {
        OutputView outputView = new OutputView();
        outputView.askUserToInsertReservationDay();
    }
}
