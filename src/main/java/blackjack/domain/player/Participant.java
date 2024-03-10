package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.rule.Score;
import java.util.Objects;

public abstract class Participant {

    protected final PlayerName name;
    protected final Hand hand;

    protected Participant(PlayerName name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public void appendCard(Card card) {
        hand.appendCard(card);
    }

    public Score calculateHandScore() {
        return hand.calculateScore();
    }

    public int countPop() {
        return hand.countPop();
    }

    public abstract boolean canHit();

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

    public String getName() {
        return name.getValue();
    }

    public Hand getHand() {
        return hand;
    }
}
