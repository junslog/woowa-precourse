package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.input.exception.BasicInputException;
import christmas.view.input.exception.DayInputException;
import christmas.view.input.parser.InputParser;
import java.util.Map;

public class InputView {
    private final InputParser inputParser;

    public InputView() {
        inputParser = new InputParser();
    }

    public int getDay() throws BasicInputException, DayInputException {
        return inputParser.parseDay(readLine());
    }

    public Map<String, Integer> getOrders() {
        return null;
    }

    private String readLine() {
        return Console.readLine();
    }
}
