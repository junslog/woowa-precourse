package christmas.domain;

import static christmas.domain.constant.DayConstant.DECEMBER_CHRISTMAS_DAY;
import static christmas.domain.constant.DayConstant.DECEMBER_FIRST_DAY;
import static christmas.domain.constant.DayConstant.DECEMBER_LAST_DAY;

import christmas.domain.exception.InvalidDayException;

public class DecemberDay extends DayPerMonth {
    private final int day;

    private DecemberDay(final int day) {
        validate(day);
        this.day = day;
    }

    public static DecemberDay from(final int day) throws InvalidDayException {
        return new DecemberDay(day);
    }

    public boolean isChristmasPromotionApplicable() {
        return day >= DECEMBER_FIRST_DAY.getDay() && day <= DECEMBER_CHRISTMAS_DAY.getDay();
    }

    private static boolean judgeIsWeekend(final int day) {
        return true;
    }

    private static boolean judgeHasStar(final int day) {
        return true;
    }

    @Override
    protected boolean isInAppropriateRange(final int day) {
        return day >= DECEMBER_FIRST_DAY.getDay() && day <= DECEMBER_LAST_DAY.getDay();
    }
}