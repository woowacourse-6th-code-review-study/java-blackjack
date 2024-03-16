package blackjack.game;

import blackjack.player.Hand;
import blackjack.player.Score;

public enum MatchResult {

    DEALER_WIN(-1),
    PLAYER_WIN(1),
    PLAYER_BLACKJACK(1.5),
    TIE(0);

    private final double rateOfPrize;

    MatchResult(double rateOfPrize) {
        this.rateOfPrize = rateOfPrize;
    }

    public static double calculateRateOfPrize(Hand playerHand, Hand dealerHand) {
        if (isPlayerBlackJackCondition(playerHand, dealerHand)) {
            return PLAYER_BLACKJACK.rateOfPrize;
        }
        if (isPlayerWinningCondition(playerHand, dealerHand)) {
            return PLAYER_WIN.rateOfPrize;
        }
        if (isDealerWinningCondition(playerHand, dealerHand)) {
            return DEALER_WIN.rateOfPrize;
        }
        return TIE.rateOfPrize;
    }

    private static boolean isPlayerBlackJackCondition(Hand playerHand, Hand dealerHand) {
        return playerHand.isBlackJack() && !dealerHand.isBlackJack();
    }

    private static boolean isPlayerWinningCondition(Hand playerHand, Hand dealerHand) {
        Score playerScore = playerHand.calculateScore();
        Score dealerScore = dealerHand.calculateScore();

        if (playerScore.isBust()) {
            return false;
        }
        return dealerScore.isBust() || playerScore.isLargerThan(dealerScore);
    }

    private static boolean isDealerWinningCondition(Hand playerHand, Hand dealerHand) {
        Score playerScore = playerHand.calculateScore();
        Score dealerScore = dealerHand.calculateScore();

        if (playerScore.isBust()) {
            return true;
        }
        if (dealerHand.isBlackJack() && !playerHand.isBlackJack()) {
            return true;
        }
        return dealerScore.isNotBust() && dealerScore.isLargerThan(playerScore);
    }

    double getRateOfPrize() {
        return rateOfPrize;
    }
}
