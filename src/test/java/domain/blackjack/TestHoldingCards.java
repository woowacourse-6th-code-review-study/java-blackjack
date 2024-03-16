package domain.blackjack;

import static domain.card.Card.ACE_HEART;
import static domain.card.Card.JACK_HEART;
import static domain.card.Card.NINE_HEART;
import static domain.card.Card.QUEEN_HEART;
import static domain.card.Card.SEVEN_HEART;
import static domain.card.Card.SIX_DIAMOND;
import static domain.card.Card.SIX_HEART;
import static domain.card.Card.TWO_HEART;

public class TestHoldingCards {
    static final HoldingCards ONLY_SIX_HEART = HoldingCards.of(SIX_HEART);
    static final HoldingCards ONLY_SEVEN_HEART = HoldingCards.of(SEVEN_HEART);
    static final HoldingCards DEAD_CARDS = HoldingCards.of(TWO_HEART, JACK_HEART, QUEEN_HEART);
    static final HoldingCards WIN_CARDS_WITH_ACE = HoldingCards.of(ACE_HEART, QUEEN_HEART);
    static final HoldingCards WIN_CARDS_WITHOUT_ACE = HoldingCards.of(TWO_HEART, JACK_HEART, NINE_HEART);
    static final HoldingCards TWO_SIX_CARDS = HoldingCards.of(SIX_HEART, SIX_DIAMOND);
}
