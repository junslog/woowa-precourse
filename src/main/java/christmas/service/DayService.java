package christmas.service;

import christmas.domain.DecemberDay;

public class DayService {
    public DecemberDay createDay(final int day) {
        return DecemberDay.from(day);
    }
}