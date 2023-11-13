package christmas.service;

import christmas.domain.DecemberDay;
import christmas.domain.exception.InvalidDayException;

public class DayService {
    public DecemberDay createDay(final int day) throws InvalidDayException {
        return DecemberDay.from(day);
    }
}