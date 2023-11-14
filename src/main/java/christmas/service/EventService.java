package christmas.service;

import static christmas.domain.constant.event.ChristmasPromotion.CHRISTMAS_D_DAY_PROMOTION;
import static christmas.domain.constant.event.EventConstant.GIFT_CHAMPAGNE_COUNT;
import static christmas.domain.constant.event.Promotion.GIFT_PROMOTION;
import static christmas.domain.constant.event.Promotion.SPECIAL_PROMOTION;
import static christmas.domain.constant.event.Promotion.WEEKDAY_PROMOTION;
import static christmas.domain.constant.event.Promotion.WEEKEND_PROMOTION;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.ReservationDay;
import christmas.domain.constant.orders.Menu;
import christmas.dto.BenefitsDetailsDto;
import christmas.dto.GiftDto;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EventService {

    public GiftDto createGiftDto(Orders orders) {
        Map<String, Integer> giftDto = new LinkedHashMap<>();
        if (orders.isGiftEventApplicable()) {
            return makeGiftDto();
        }
        return GiftDto.from(giftDto);
    }

    private GiftDto makeGiftDto() {
        return GiftDto.from(Collections.singletonMap(Menu.CHAMPAGNE.getName(), GIFT_CHAMPAGNE_COUNT.getValue()));
    }

    public BenefitsDetailsDto createBenefitsDetailsDto(ReservationDay reservationDay, Orders orders) {
        Map<String, Integer> benefitsDetails = new LinkedHashMap<>();
        if (orders.isEventApplicable()) {
            return makeBenefitsDetailsDto(benefitsDetails, reservationDay, orders);
        }
        return BenefitsDetailsDto.from(benefitsDetails);
    }

    private BenefitsDetailsDto makeBenefitsDetailsDto(Map<String, Integer> benefitsDetails,
                                                      ReservationDay reservationDay, Orders orders) {
        addChristmasPromotionDetails(benefitsDetails, reservationDay);
        addWeekdayPromotionDetails(benefitsDetails, reservationDay, orders);
        addWeekendPromotionDetails(benefitsDetails, reservationDay, orders);
        addSpecialPromotionDetails(benefitsDetails, reservationDay);
        addGiftPromotionDetails(benefitsDetails, orders);
        return BenefitsDetailsDto.from(benefitsDetails);
    }

    private void addChristmasPromotionDetails(Map<String, Integer> benefitsDetails, ReservationDay reservationDay) {
        if (reservationDay.isChristmasPromotionApplicable()) {
            benefitsDetails.put(CHRISTMAS_D_DAY_PROMOTION.getName(),
                    calculateChristmasPromotionBenefitAmount(reservationDay));
        }
    }

    private int calculateChristmasPromotionBenefitAmount(ReservationDay reservationDay) {
        return CHRISTMAS_D_DAY_PROMOTION.getBenefitAmount(reservationDay.getDay());
    }

    private void addWeekdayPromotionDetails(Map<String, Integer> benefitsDetails, ReservationDay reservationDay,
                                            Orders orders) {
        if (reservationDay.isWeekdayPromotionApplicable()) {
            benefitsDetails.put(WEEKDAY_PROMOTION.getName(),
                    calculateWeekdayPromotionBenefitAmount(reservationDay, orders));
        }
    }

    private int calculateWeekdayPromotionBenefitAmount(ReservationDay reservationDay, Orders orders) {
        int count = orders.getOrders().stream()
                .filter(Order::isWeekdayPromotionApplicable)
                .collect(Collectors.collectingAndThen(Collectors.counting(), Long::intValue));
        return WEEKDAY_PROMOTION.getBenefitAmount() * count;
    }

    private void addWeekendPromotionDetails(Map<String, Integer> benefitsDetails, ReservationDay reservationDay,
                                            Orders orders) {
        if (reservationDay.isWeekendPromotionApplicable()) {
            benefitsDetails.put(WEEKEND_PROMOTION.getName(),
                    calculateWeekendPromotionBenefitAmount(reservationDay, orders));
        }
    }

    private int calculateWeekendPromotionBenefitAmount(ReservationDay reservationDay, Orders orders) {
        int count = orders.getOrders().stream()
                .filter(Order::isWeekendPromotionApplicable)
                .collect(Collectors.collectingAndThen(Collectors.counting(), Long::intValue));
        return WEEKEND_PROMOTION.getBenefitAmount() * count;
    }

    private void addSpecialPromotionDetails(Map<String, Integer> benefitsDetails, ReservationDay reservationDay) {
        if (reservationDay.isSpecialPromotionApplicable()) {
            benefitsDetails.put(SPECIAL_PROMOTION.getName(), calculateSpecialPromotionBenefitAmount());
        }
    }

    private int calculateSpecialPromotionBenefitAmount() {
        return SPECIAL_PROMOTION.getBenefitAmount();
    }

    private void addGiftPromotionDetails(Map<String, Integer> benefitsDetails, Orders orders) {
        if (orders.isGiftEventApplicable()) {
            benefitsDetails.put(GIFT_PROMOTION.getName(), calculateGiftPromotionBenefitAmount());
        }
    }

    private int calculateGiftPromotionBenefitAmount() {
        return GIFT_PROMOTION.getBenefitAmount();
    }
}