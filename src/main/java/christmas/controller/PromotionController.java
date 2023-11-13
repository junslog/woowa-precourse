package christmas.controller;

import christmas.domain.DecemberDay;
import christmas.domain.exception.InvalidDayException;
import christmas.service.DayService;
import christmas.view.input.InputView;
import christmas.view.input.exception.BasicInputException;
import christmas.view.output.OutputView;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DayService dayService;

    public PromotionController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.dayService = new DayService();
    }

    public void run() {
        outputView.printGreetingMessage();
        DecemberDay day = insertDay();
        System.out.println(day);
    }

    private DecemberDay insertDay() {
        try {
            int reservationDay = askToInsertReservationDay();
            return dayService.createDay(reservationDay);
        } catch (BasicInputException | InvalidDayException e) {
            outputView.printErrorMessage(e.getMessage());
            return insertDay();
        }
    }

    private int askToInsertReservationDay() {
        outputView.askToInsertReservationDay();
        return inputView.getDay();
    }
}
