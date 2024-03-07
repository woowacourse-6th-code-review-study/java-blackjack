package blackjack.domain;

public record Score(int value) {
    private static final int MINIMUM_VALUE = 0;
    private static final int BUST_THRESHOLD = 21;
    private static final int DEALER_MINIMUM_SCORE = 17;

    public Score {
        validateRange(value);
    }

    private void validateRange(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("음수는 점수로 사용될 수 없습니다.");
        }
    }

    public boolean isBusted() {
        return value > BUST_THRESHOLD;
    }

    public boolean isLessThanDealerMinimumScore() {
        return value < DEALER_MINIMUM_SCORE;
    }

    public boolean isGreaterThan(Score relativeScore) {
        return value > relativeScore.value;
    }

    public boolean isSame(Score relativeScore) {
        return value == relativeScore.value;
    }

    public boolean isLessThan(Score relativeScore) {
        return value < relativeScore.value;
    }
}
