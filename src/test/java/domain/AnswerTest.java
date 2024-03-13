package domain;

import exception.InvalidCommandException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AnswerTest {

    @ParameterizedTest
    @DisplayName("y혹은 n이 아닐시 예외가 발생한다.")
    @ValueSource(strings = {"Y", "nn", "aa"})
    void invalidAnswer(String value) {
        Assertions.assertThatThrownBy(() -> Answer.from(value))
                .isInstanceOf(InvalidCommandException.class);
    }
}
