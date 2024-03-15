package blackjack.domain.betting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100000000})
    void 돈이_정상적으로_생성된다(final int value) {
        assertThatCode(() -> new Money(value))
                .doesNotThrowAnyException();
    }

    @Test
    void 음수의_돈은_만들어지지_않는다() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈의 액수는 0 이상이어야 합니다.");
    }

    @Test
    void 돈의_액수를_음수로_반환한다() {
        Money money = new Money(1);

        assertThat(money.minusValue()).isEqualTo(-1);
    }

    @Test
    void 돈의_액수에_곱한_값을_반환한다() {
        Money money = new Money(2);

        assertThat(money.multipleValue(1.5)).isEqualTo(3);
    }

    @Test
    void 돈의_액수가_홀수면_곱하고_1의_자리를_반환한다() {
        Money money = new Money(1);

        assertThat(money.multipleValue(1.5)).isEqualTo(1);
    }
}
