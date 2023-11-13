package christmas.view.output;

import static christmas.view.output.constant.OutputConstant.NEW_LINE;

public class OutputView {

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