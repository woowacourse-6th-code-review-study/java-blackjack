package domain;

import static domain.HandsTestFixture.sum19Size3Ace1;
import static domain.HandsTestFixture.sum19Size4Ace11;
import static domain.HandsTestFixture.sum20Size2;
import static domain.HandsTestFixture.sum20Size3Ace1;
import static domain.HandsTestFixture.sum21Size3Ace11;
import static domain.card.Rank.EIGHT;
import static domain.card.Shape.CLOVER;

import domain.card.Card;
import domain.participant.Hands;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandsTest {

    @Test
    @DisplayName("카드를 가지고 있는 객체를 생성한다.")
    void createPacket() {
        Assertions.assertThatCode(Hands::createEmptyHands)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("카드를 추가한다.")
    void addCard() {
        //given
        final Hands hands = Hands.createEmptyHands();

        //when
        hands.add(new Card(EIGHT, CLOVER));

        //then
        Assertions.assertThat(hands.size()).isEqualTo(1);
    }

    @DisplayName("카드의 합을 구한다.")
    @Test
    void sum() {
        Assertions.assertThat(sum20Size2.sum()).isEqualTo(20);
    }

    @DisplayName("에이스를 11로 계산한다.")
    @ParameterizedTest
    @MethodSource("sumAce11ParameterProvider")
    void sumAce11(final Hands hands, final int expected) {
        // given & when
        final int result = hands.sum();

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("에이스를 1로 계산한다.")
    @ParameterizedTest
    @MethodSource("sumAce1ParameterProvider")
    void sumAce1(final Hands hands, final int expected) {
        // given & when
        final int result = hands.sum();

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> sumAce11ParameterProvider() {
        return Stream.of(
                Arguments.of(sum21Size3Ace11, 21),
                Arguments.of(sum19Size4Ace11, 19)
        );
    }

    static Stream<Arguments> sumAce1ParameterProvider() {
        return Stream.of(
                Arguments.of(sum19Size3Ace1, 19),
                Arguments.of(sum20Size3Ace1, 20)
        );
    }
}
