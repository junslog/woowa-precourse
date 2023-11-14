package christmas.service;

import static christmas.domain.constant.EventConstant.GIFT_CHAMPAGNE_COUNT;

import christmas.domain.Orders;
import christmas.domain.constant.Menu;
import christmas.dto.GiftDto;
import java.util.Collections;
import java.util.Optional;

public class EventService {

    public Optional<GiftDto> createGiftDto(Orders orders) {
        if (orders.isGiftEventApplicable()) {
            return Optional.of(makeGiftDto());
        }
        return Optional.empty();
    }

    private GiftDto makeGiftDto() {
        return GiftDto.from(Collections.singletonMap(Menu.CHAMPAGNE.getName(), GIFT_CHAMPAGNE_COUNT.getValue()));
    }
}