package christmas.view.output;

import static christmas.view.output.constant.OutputConstant.NEW_LINE;
import static christmas.view.output.constant.OutputMessage.INSERT_RESERVATION_DAY;

public class OutputView {

    public void askUserToInsertReservationDay() {
        printMessage(INSERT_RESERVATION_DAY.getMessage());
        printLine();
    }


    public void printLine() {
        System.out.print(NEW_LINE);
    }

    public void printErrorMessage(final String message) {
        printMessage(message);
    }

    private <T> void printMessage(final T message) {
        System.out.print(message);
    }
}