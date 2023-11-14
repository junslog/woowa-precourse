package christmas.service;

import christmas.domain.ReservationDay;
import christmas.domain.exception.InvalidDayException;
import christmas.dto.EventBenefitsPreviewDto;

public class DayService {
    public ReservationDay createDay(final int day) throws InvalidDayException {
        return ReservationDay.from(day);
    }

    public EventBenefitsPreviewDto createEvenetBenefitsPreviewDto(ReservationDay day) {
        return EventBenefitsPreviewDto.from(day.getDay());
    }
}