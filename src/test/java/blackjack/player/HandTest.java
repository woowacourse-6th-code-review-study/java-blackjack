package blackjack.player;

import static org.assertj.core.api.Assertions.assertThat;

import blackjack.card.Card;
import blackjack.card.Rank;
import blackjack.card.Shape;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandTest {

    @Test
    @DisplayName("플레이어의 점수를 계산한다.")
    void calculateScoreTest() {
        // given
        List<Card> cards = List.of(
                new Card(Shape.SPADE, Rank.KING),
                new Card(Shape.HEART, Rank.EIGHT)
        );
        Hand hand = new Hand(cards);
        // when, then
        assertThat(hand.calculateScore()).isEqualTo(new Score(18));
    }

    @Test
    @DisplayName("플레이어의 점수를 계산할 때, Ace의 점수를 유리한 방향(11)으로 결정한다.")
    void calculateAceAsElevenTest() {
        // given
        List<Card> cards = List.of(
                new Card(Shape.HEART, Rank.TEN),
                new Card(Shape.CLOVER, Rank.ACE)
        );
        Hand hand = new Hand(cards);
        // when, then
        assertThat(hand.calculateScore()).isEqualTo(new Score(21));
    }

    @Test
    @DisplayName("플레이어의 점수를 계산할 때, Ace의 점수를 유리한 방향(1)으로 결정한다.")
    void calculateAceAsOneTest() {
        // given
        List<Card> cards = List.of(
                new Card(Shape.HEART, Rank.TEN),
                new Card(Shape.CLOVER, Rank.ACE),
                new Card(Shape.DIAMOND, Rank.TEN)
        );
        Hand hand = new Hand(cards);
        // when, then
        assertThat(hand.calculateScore()).isEqualTo(new Score(21));
    }
}
