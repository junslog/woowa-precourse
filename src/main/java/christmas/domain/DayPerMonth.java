package christmas.domain;

import static christmas.domain.exception.message.InvalidDayExceptionMessage.NOT_IN_APPROPRIATE_RANGE;

import christmas.domain.exception.InvalidDayException;

public abstract class DayPerMonth {
    protected int FIRST_DAY;
    protected int LAST_DAY;

    public DayPerMonth(final int day) {
        validate(day);
    }

    protected void validate(final int day) {
        if (!isInAppropriateRange(day)) {
            throw InvalidDayException.of(NOT_IN_APPROPRIATE_RANGE);
        }
    }

    protected boolean isInAppropriateRange(final int day) {
        return day >= FIRST_DAY && day <= LAST_DAY;
    }
}