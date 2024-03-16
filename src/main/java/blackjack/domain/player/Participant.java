package blackjack.domain.player;

import blackjack.domain.Score;
import blackjack.domain.card.Card;
import blackjack.domain.card.Hand;
import java.util.Objects;

public abstract class Participant {

    protected final PlayerName name;
    protected final Hand hand;

    protected Participant(PlayerName name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public abstract boolean canHit();

    public void appendCard(Card card) {
        hand.appendCard(card);
    }

    public Score calculateHandScore() {
        return hand.calculateScore();
    }

    public int countDraw() {
        return hand.countDraw();
    }

    public boolean isBusted() {
        return hand.calculateScore().isBustScore();
    }

    public boolean isNotBusted() {
        return !hand.calculateScore().isBustScore();
    }

    public boolean hasBlackJackHand() {
        return hand.isBlackJack();
    }

    public boolean hasNoBlackJackHand() {
        return !hand.isBlackJack();
    }

    public boolean hasScoreAbove(Participant other) {
        return this.calculateHandScore().isAbove(other.calculateHandScore());
    }

    public boolean hasSameScore(Participant other) {
        return this.calculateHandScore().equals(other.calculateHandScore());
    }

    public String getName() {
        return name.getValue();
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant participant = (Participant) o;
        return Objects.equals(name, participant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
