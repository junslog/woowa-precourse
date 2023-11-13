package christmas.domain.constant;

public enum DayConstant {
    
    DECEMBER_FIRST_DAY(1),
    DECEMBER_LAST_DAY(31);

    private final int day;

    DayConstant(final int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}