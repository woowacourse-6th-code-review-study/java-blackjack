package domain.blackjack;

import domain.card.Card;
import domain.card.CardSelectStrategy;
import domain.card.Deck;
import java.util.List;

abstract class Gamer {
    protected final BlackJackGameMachine blackJackGameMachine;

    public Gamer(BlackJackGameMachine blackJackGameMachine) {
        this.blackJackGameMachine = blackJackGameMachine;
    }

    public abstract DrawResult draw(Deck deck, CardSelectStrategy cardSelectStrategy);

    public final List<Card> getRawHoldingCards() {
        return blackJackGameMachine.getRawHoldingCards();
    }

    public final int calculateSummationCardPointAsInt() {
        return blackJackGameMachine.calculateSummationCardPointAsInt();
    }

    public final GameResult calculateGameResult(Gamer other) {
        return GameResultCalculator.calculate(this, other);
    }

    final SummationCardPoint calculateSummationCardPoint() {
        return blackJackGameMachine.calculateSummationCardPoint();
    }

    final boolean isBust() {
        return blackJackGameMachine.isBust();
    }
}
