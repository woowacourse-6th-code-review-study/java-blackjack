package domain.blackjack;

import java.util.List;

public record SummationCardPoint(int summationCardPoint) {
    private static final int DEAD_POINT_THRESHOLD = 21;

    static SummationCardPoint of(List<CardPoint> cardPoints) {
        int summationCardPoint = cardPoints.stream()
                .mapToInt(CardPoint::point)
                .sum();
        return new SummationCardPoint(summationCardPoint);
    }

    boolean isBiggerThan(SummationCardPoint other) {
        int otherPoint = other.summationCardPoint();
        return summationCardPoint > otherPoint;
    }

    boolean isDeadPoint() {
        return this.isBiggerThan(new SummationCardPoint(DEAD_POINT_THRESHOLD));
    }
}
