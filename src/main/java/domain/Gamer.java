package domain;

import java.util.List;

public class Gamer {
    private final String name;
    private final HoldingCards holdingCards;

    public Gamer(String name, HoldingCards holdingCards) {
        this.name = name;
        this.holdingCards = holdingCards;
    }

    public void draw(Deck deck, CardDrawStrategy cardDrawStrategy, SummationCardPoint thresholdPoint) {
        validateCanDraw(thresholdPoint);
        holdingCards.add(deck.draw(cardDrawStrategy));
    }

    private void validateCanDraw(SummationCardPoint thresholdPoint) {
        if (getSummationCardPoint().isBiggerThan(thresholdPoint)) {
            throw new IllegalStateException("카드를 더이상 뽑을 수 없습니다.");
        }
    }

    public SummationCardPoint getSummationCardPoint() {
        return holdingCards.calculateTotalPoint();
    }

    public String getRawName() {
        return name;
    }

    public List<Card> getRawHoldingCards() {
        return holdingCards.getHoldingCards();
    }

    public int getRawSummationCardPoint() {
        return holdingCards.calculateTotalPoint().summationCardPoint();
    }

    public boolean isDead() {
        return holdingCards.calculateTotalPoint().isBiggerThan(new SummationCardPoint(21));
    }
}
