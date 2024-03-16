package domain.blackjack;

import static domain.card.CardName.TEN;

import domain.card.Card;
import domain.card.CardName;
import java.util.Arrays;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CardPointCalculatorTest {
    static Stream<Arguments> calculateParameter() {
        return Stream.of(Arrays.stream(Card.values())
                .map(card -> Arguments.of(card, makeCardPoint(card.cardName())))
                .toArray(Arguments[]::new));
    }

    private static CardPoint makeCardPoint(CardName cardName) {
        CardPoint cardPoint = new CardPoint(cardName.getCardNumber());
        if (cardName.getCardNumber() > TEN.getCardNumber()) {
            return new CardPoint(TEN.getCardNumber());
        }
        return cardPoint;
    }

    @ParameterizedTest
    @MethodSource("calculateParameter")
    @DisplayName("카드 점수가 제대로 변환되는지 검증")
    void calculate(Card card, CardPoint expected) {
        CardPoint cardPoint = CardPointCalculator.calculate(card);
        Assertions.assertThat(cardPoint)
                .isEqualTo(expected);
    }
}
