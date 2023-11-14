package christmas.domain;

import static christmas.domain.constant.DayConstant.DECEMBER_LAST_DAY;
import static christmas.domain.constant.DayConstant.DEFAULT_FIRST_DAY;
import static christmas.domain.exception.message.InvalidDayExceptionMessage.NOT_IN_APPROPRIATE_RANGE;

import christmas.domain.exception.InvalidDayException;

public abstract class DayPerMonth {
    public DayPerMonth() {
    }

    protected void validate(final int day) {
        if (!isInAppropriateRange(day)) {
            throw InvalidDayException.of(NOT_IN_APPROPRIATE_RANGE.getMessage());
        }
    }

    protected boolean isInAppropriateRange(final int day) {
        return day >= DEFAULT_FIRST_DAY.getDay() && day <= DECEMBER_LAST_DAY.getDay();
    }
}