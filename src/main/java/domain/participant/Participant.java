package domain.participant;

import domain.Result;
import domain.card.Card;
import java.util.List;
import java.util.Objects;

public abstract class Participant {

    private final Name name;
    private final Hands hands;

    protected Participant(final Name name, final Hands hands) {
        this.name = name;
        this.hands = hands;
    }

    public abstract boolean canDeal();

    public void add(final Card card) {
        hands.add(card);
    }

    public boolean isBust() {
        return hands.isBust();
    }

    //TODO 시작시에 블랙잭일 때 쓸거에용
    public boolean isBlackJack() {
        return hands.isBlackJack();
    }

    public int handsSum() {
        return hands.sum();
    }

    public int handsSize() {
        return hands.size();
    }

    public Result calculateResult(final Participant participant) {
        return hands.calculateResult(participant.getHands());
    }

    public List<String> getCardNames() {
        return hands.getCards();
    }

    public String getName() {
        return name.getValue();
    }

    public Hands getHands() {
        return hands;
    }

    @Override
    public boolean equals(final Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof Participant participant)) {
            return false;
        }
        return Objects.equals(name, participant.name) && Objects.equals(hands, participant.hands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hands);
    }
}
