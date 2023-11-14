package christmas.controller;

import christmas.view.input.InputView;
import christmas.view.output.OutputView;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}