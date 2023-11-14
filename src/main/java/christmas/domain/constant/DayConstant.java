package christmas.domain.constant;

public enum DayConstant {
    DEFAULT_FIRST_DAY(1),
    DEFAULT_LAST_DAY(30),
    DECEMBER_FIRST_DAY(1),
    DECEMBER_LAST_DAY(31),
    DECEMBER_CHRISTMAS_DAY(25);

    private final int day;

    DayConstant(final int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}