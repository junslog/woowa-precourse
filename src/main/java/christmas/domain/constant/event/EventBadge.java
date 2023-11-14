package christmas.domain.constant.event;

public enum EventBadge {
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000),
    NONE("없음", 0);

    private final String name;
    private final int minimumTotalBenefitedPrice;

    EventBadge(final String name, final int minimumTotalBenefitedPrice) {
        this.name = name;
        this.minimumTotalBenefitedPrice = minimumTotalBenefitedPrice;
    }

    public static EventBadge getBadgeByBenefitedPrice(final int totalBenefitedPrice) {
        if (isNone(totalBenefitedPrice)) {
            return NONE;
        }
        if (isStar(totalBenefitedPrice)) {
            return STAR;
        }
        if (isTree(totalBenefitedPrice)) {
            return TREE;
        }
        return SANTA;
    }

    private static boolean isNone(final int totalBenefitedPrice) {
        return totalBenefitedPrice >= NONE.minimumTotalBenefitedPrice
                || totalBenefitedPrice < STAR.minimumTotalBenefitedPrice;
    }

    private static boolean isStar(final int totalBenefitedPrice) {
        return totalBenefitedPrice >= STAR.minimumTotalBenefitedPrice
                || totalBenefitedPrice < TREE.minimumTotalBenefitedPrice;
    }

    private static boolean isTree(final int totalBenefitedPrice) {
        return totalBenefitedPrice >= TREE.minimumTotalBenefitedPrice
                || totalBenefitedPrice < SANTA.minimumTotalBenefitedPrice;
    }

    public String getName() {
        return name;
    }
}