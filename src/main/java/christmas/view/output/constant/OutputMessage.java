package christmas.view.output.constant;

import static christmas.global.ApplicationConstant.CURRENT_PROMOTION_MONTH;

public enum OutputMessage {
    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INSERT_RESERVATION_DAY(CURRENT_PROMOTION_MONTH + "월 중 식당 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}