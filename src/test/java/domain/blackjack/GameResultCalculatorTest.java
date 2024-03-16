package domain.blackjack;

import static domain.blackjack.GameResult.LOSE;
import static domain.blackjack.GameResult.TIE;
import static domain.blackjack.GameResult.WIN;
import static domain.blackjack.TestHoldingCards.DEAD_CARDS;
import static domain.blackjack.TestHoldingCards.ONLY_SEVEN_HEART;
import static domain.blackjack.TestHoldingCards.ONLY_SIX_HEART;
import static domain.blackjack.TestHoldingCards.TWO_SIX_CARDS;
import static domain.blackjack.TestHoldingCards.WIN_CARDS_WITHOUT_ACE;
import static domain.blackjack.TestHoldingCards.WIN_CARDS_WITH_ACE;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameResultCalculatorTest {

    public static Stream<Arguments> getGameResultParameters() {
        return Stream.of(
                Arguments.of(new BlackJackGameMachine(ONLY_SEVEN_HEART),
                        new BlackJackGameMachine(ONLY_SIX_HEART), WIN),
                Arguments.of(new BlackJackGameMachine(ONLY_SIX_HEART),
                        new BlackJackGameMachine(ONLY_SEVEN_HEART), LOSE),
                Arguments.of(new BlackJackGameMachine(ONLY_SEVEN_HEART),
                        new BlackJackGameMachine(ONLY_SEVEN_HEART), TIE),
                Arguments.of(new BlackJackGameMachine(DEAD_CARDS),
                        new BlackJackGameMachine(ONLY_SEVEN_HEART), LOSE),
                Arguments.of(new BlackJackGameMachine(ONLY_SEVEN_HEART),
                        new BlackJackGameMachine(DEAD_CARDS), WIN),
                Arguments.of(new BlackJackGameMachine(DEAD_CARDS), new BlackJackGameMachine(DEAD_CARDS),
                        TIE),
                Arguments.of(new BlackJackGameMachine(WIN_CARDS_WITH_ACE),
                        new BlackJackGameMachine(TWO_SIX_CARDS), WIN),
                Arguments.of(new BlackJackGameMachine(WIN_CARDS_WITH_ACE),
                        new BlackJackGameMachine(WIN_CARDS_WITHOUT_ACE), TIE)
        );
    }

    @ParameterizedTest
    @MethodSource("getGameResultParameters")
    @DisplayName("승부가 잘 결정되는지 검증")
    void calculate(BlackJackGameMachine blackJackGameMachine1, BlackJackGameMachine blackJackGameMachine2,
                   GameResult expected) {
        Assertions.assertThat(GameResultCalculator.calculate(blackJackGameMachine1, blackJackGameMachine2))
                .isEqualTo(expected);
    }
}
